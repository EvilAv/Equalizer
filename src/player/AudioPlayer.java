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
    private final RingBuf ring;

    public boolean isCalculated = false;
    private final int BUFF_SIZE = 65536;

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



    // конструктор
    public AudioPlayer(File musicFile) throws UnsupportedAudioFileException,
            IOException, InterruptedException, LineUnavailableException {
        // читаем файл
        ReadMusicFile readFile = new ReadMusicFile(musicFile);
        // задаем буфер для воспроизведения файла, обращающийся к микшеру
        this.sourceDataLine =  readFile.getSourceDataLine();
        // задаем входной звуковой поток
        this.ais = readFile.getAudioInputStream();
        this.buff = new byte[this.BUFF_SIZE];
        this.sampleBuff = new short[BUFF_SIZE / 2];
        // инициализируем эффекты
        this.delay = new Delay();
        this.vibrato = new Vibrato();
        // отключаем эффекты, чтобы изначально воспроизводить чисытй звук
        this.isDelay = false;
        this.isVibrato = false;
        this.vibratoCoef = 1.0;
        // инициализируем класс эквалайзера
        this.equalizer = new Equalizer(BUFF_SIZE / 2);
        AudioFileFormat aff = new AudioFileFormat();
        format = new AudioFormat((float)aff.getSampleRate(),
                aff.getBits(), aff.getChannels(),
                aff.isSigned(), aff.isBigEndian());
        this.volume = 1.0;
        this.fourierInput = new FFT();
        this.fourierOutput = new FFT();
        this.ring = new RingBuf(BUFF_SIZE);
    }


    // воспроизводим звук
    public void play() {
        try{
            this.sourceDataLine.open(this.format);
            this.sourceDataLine.start();
            this.pause = false;
            int temp = 0;
            while (temp != -1){
                // запись в кольцевой буфер
                while (!ring.isFull()) {
                    temp = this.ais.read();
                    if (temp == -1)
                        break;
                    this.ring.push((byte) temp);
                }
                // чтение из кольцевого буфера
                int i = 0;
                while (!ring.isEmpty()) {
                    this.buff[i] = ring.pop();
                    i++;
                }
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
                // преобразуем измененный сигнал в байты и воспроизводим
                sourceDataLine.write(this.buff, 0, this.buff.length - 0 );

            }
            System.out.println("END");
            this.isCalculated = false;
            this.sourceDataLine.drain();
            this.sourceDataLine.close();
        }catch (LineUnavailableException | IOException | InterruptedException | ExecutionException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // задаем эффект Дилей
    private void delay(short[] inputSamples) {
        this.delay.setInputSampleStream(inputSamples);
        this.delay.createEffect();
    }

    // проверяем активен ли эффект Дилей
    public boolean delayIsActive() {
        return this.isDelay;
    }

    // отключаем/подключаем эффект Дилей
    public void setDelay(boolean b) {
        this.isDelay = b;
    }

    // задаем эффект Вибрато
    private void vibrato(short[] inputSamples) {
        this.vibrato.setVibratoCoef(this.vibratoCoef);
        this.vibrato.setInputSampleStream(inputSamples);
        this.vibrato.createEffect();
    }

    // проверяем активен ли эффект Вибрато
    public boolean vibratoIsActive() {
        return this.isVibrato;
    }

    // отключаем/подключаем эффект Вибрато
    public void setVibrato(boolean b) {
        this.isVibrato = b;
    }

    // задаем коэффициент для эффекта Вибрато
    public void setVibratoCoef(double c) {
        this.vibratoCoef = c;
    }


    // присотанавливаем воспроизведение
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

    // устанавливаем громкость
    public void setVolume(double volume) {
        this.volume = volume;
    }

    // получаем значение громкости
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

    // преобразуем массив байтов в массив отсчетов, реализуем кольцевой буффер
    private void ByteArrayToSamplesArray() {
        for(int i = 0, j = 0; i < this.buff.length; i += 2 , j++) {
            this.sampleBuff[j] = (short) (0.5 *  (ByteBuffer.wrap(this.buff, i, 2).order(
                    java.nio.ByteOrder.LITTLE_ENDIAN).getShort()) * this.getVolume());
        }
    }

    // преобразуем массив отсчетов (реализованный кольцевым буфером) в массив байтов
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

    // заврешаем воспроизведение звука и заврешаем все системные процессы связанные с ним
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
