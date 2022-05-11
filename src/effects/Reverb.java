package effects;


public class Reverb extends Effect{

    public Reverb() {
        super();
    }

    public void setInputSampleStream(short[] inputAudioStream) {
        this.inputAudioStream = inputAudioStream;
    }

    @Override
    public synchronized short[] createEffect() {

        short amplitude;
        short delayAmplitude;
        int checkFlag;
        int delay = 5000; // определяем задержку, т.е спутся какое число отсчетов будем уменьшать амплитуду сигнала
        int position = 0;

        // добавляем эффект Дилей к входящему сигналу
        for(int i = delay ; i < this.inputAudioStream.length; i ++) {
            // получаем амплитуду указанного отсчета
            amplitude = this.inputAudioStream[i];
            // получаем амплитуду с задержкой
            delayAmplitude = this.inputAudioStream[position];
            // вычисляем новую амплитуду по формуле
            checkFlag = ( (( delayAmplitude) - (int)(0.9 * amplitude)));
            // если чилсо не превышает размер типа short, то меняем амплитуду отсчета с задержкой
            if(checkFlag < Short.MAX_VALUE && checkFlag > Short.MIN_VALUE) {
                delayAmplitude = (short)checkFlag;
                this.inputAudioStream[position] =  delayAmplitude;
                position += 1;
            }
        }
        return this.inputAudioStream;
    }

    @Override
    public synchronized short[] getOutputAudioStream() {
        return this.inputAudioStream;
    }
}
