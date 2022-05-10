package player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReadMusicFile{
    private AudioInputStream ais;
    private byte[] outputSignal;
    private SourceDataLine sdl;

    public ReadMusicFile(File filePath) throws UnsupportedAudioFileException, IOException, InterruptedException, LineUnavailableException {
        // считываем файл, если он существует
        if(filePath != null) {
            this.ais = AudioSystem.getAudioInputStream(filePath);
            AudioFormat format = ais.getFormat();
            this.sdl = AudioSystem.getSourceDataLine(format);
            this.sdl.flush();
        }

    }

    public byte[] getOutputSignal() {
        return this.outputSignal;
    }
    // возвращаем входной поток данных
    public AudioInputStream getAudioInputStream() {
        return this.ais;
    }
    // закрываем входной поток данных
    public void closeAudioInputStream() {
        try {
            this.ais.close();
        } catch (IOException e) {
        }
    }
    // получаем строку данных, обращающуюся к микшеру
    public SourceDataLine getSourceDataLine() {
        return this.sdl;
    }
}
