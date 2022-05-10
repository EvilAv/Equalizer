package player;

import effects.Delay;
import effects.Vibrato;
import equalizer.Equalizer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;

public class AudioPlayer implements LineListener{
    private double volume;
    private final SourceDataLine sourceDataLine;
    private final AudioInputStream ais;
    private final byte[] buff;

    public boolean isCalculated = false;
    private final int BUFF_SIZE = 131072;

    private short[] sampleBuff;

    private final FFT fourierInput;
    public FFT fourierOutput;

    private final Delay delay;
    private boolean isDelay;

    private final Vibrato vibrato;
    private double vibratoCoef;
    private boolean isVibrato;

    private final Equalizer equalizer;
    private boolean pause;
    private final AudioFormat format;



    public AudioPlayer(File musicFile) throws UnsupportedAudioFileException,
            IOException, InterruptedException, LineUnavailableException {
        ReadMusicFile readFile = new ReadMusicFile(musicFile);
        this.sourceDataLine =  readFile.getSourceDataLine();
        this.ais = readFile.getAudioInputStream();
        this.buff = new byte[this.BUFF_SIZE];
        this.sampleBuff = new short[BUFF_SIZE / 2];
        this.delay = new Delay();
        this.vibrato = new Vibrato();
        this.isDelay = false;
        this.isVibrato = false;
        this.vibratoCoef = 1.0;
        this.equalizer = new Equalizer(BUFF_SIZE / 2);
        AudioFileFormat aff = new AudioFileFormat();
        format = new AudioFormat((float)aff.getSampleRate(),
                aff.getBits(), aff.getChannels(),
                aff.isSigned(), aff.isBigEndian());
        this.volume = 1.0;
        this.fourierInput = new FFT();
        this.fourierOutput = new FFT();
    }


    public void play() {
        try{
            this.sourceDataLine.open(this.format);
            this.sourceDataLine.start();
            this.pause = false;
            while ((this.ais.read(this.buff, 0, this.BUFF_SIZE)) != -1) {
                this.ByteArrayToSamplesArray();

                //отрисовка без изменения sampleBuff
                this.isCalculated = false;

                this.fourierInput.FFTAnalysis(this.sampleBuff, 512);
                if(this.pause) {this.stop();}

                if(this.isDelay)
                    this.delay(this.sampleBuff);

                if(this.isVibrato) {
                    this.vibrato(sampleBuff);
                }

                equalizer.setInputSignal(this.sampleBuff);
                this.equalizer.equalization();
                this.sampleBuff = equalizer.getOutputSignal();


                //отрисовка с изменением
                this.fourierOutput.FFTAnalysis(this.sampleBuff, 512);
                this.isCalculated = true;
                this.SampleArrayByteArray();
                sourceDataLine.write(this.buff, 0, this.buff.length - 0 );
            } System.out.println("END");
            this.isCalculated = false;
            this.sourceDataLine.drain();
            this.sourceDataLine.close();
        }catch (LineUnavailableException | IOException | InterruptedException | ExecutionException e) {
        }
    }


    private void delay(short[] inputSamples) {
        this.delay.setInputSampleStream(inputSamples);
        this.delay.createEffect();
    }

    public boolean delayIsActive() {
        return this.isDelay;
    }

    public void setDelay(boolean b) {
        this.isDelay = b;
    }

    private void vibrato(short[] inputSamples) {
        this.vibrato.setVibratoCoef(this.vibratoCoef);
        this.vibrato.setInputSampleStream(inputSamples);
        this.vibrato.createEffect();
    }

    public boolean vibratoIsActive() {
        return this.isVibrato;
    }

    public void setVibrato(boolean b) {
        this.isVibrato = b;
    }

    public void setVibratoCoef(double c) {
        this.vibratoCoef = c;
    }


    private void stop() {
        if(pause) {
            for(;;) {
                try {
                    if(!pause) break;
                    this.isCalculated = false;
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                }
            }
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean getPause() {
        return this.pause;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
    }

    public short[] getSamples() {
        return this.sampleBuff;
    }

    private void ByteArrayToSamplesArray() {
        for(int i = 0, j = 0; i < this.buff.length; i += 2 , j++) {
            this.sampleBuff[j] = (short) (0.5 *  (ByteBuffer.wrap(this.buff, i, 2).order(
                    java.nio.ByteOrder.LITTLE_ENDIAN).getShort()) * this.getVolume());
        }
    }

    private void SampleArrayByteArray() {
        for(int i = 0, j = 0; i < this.sampleBuff.length && j < (this.buff.length); i++, j += 2 ) {
            this.buff[j] = (byte)(this.sampleBuff[i]);
            this.buff[j + 1] = (byte)(this.sampleBuff[i] >>> 8);
//
        }
    }

    public Equalizer getEqualizer() {
        return this.equalizer;
    }

    public void close() {
        if(this.ais != null)
            try {
                this.ais.close();
            }
            catch (IOException e) {
            }
        if(this.sourceDataLine != null)
            this.sourceDataLine.close();
    }

    public double[] getFourierInput(){
        return this.fourierInput.getFFTData();
    }
    public double[] getFourierOutput(){
        return this.fourierOutput.getFFTData();
    }
}
