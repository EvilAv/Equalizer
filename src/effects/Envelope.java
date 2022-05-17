package effects;

public class Envelope extends Effect {

    private short maxAmplitude;
    private short minAmplitude;
    private static final short standartMax = 350;
    private static final short standartMin = -350;
    private double coef;

    public Envelope() {
        super();
        this.coef = 20.0;
    }

    public void setInputSampleStream(short[] inputAudioStream) {
        this.inputAudioStream = inputAudioStream;
    }

    // реализуем эффект Вибрато
    @Override
    public synchronized short[] createEffect() {
        this.setMaxAndMinAmpl();
        for(int i = 0; i < this.inputAudioStream.length; i ++) {
            if(this.inputAudioStream[i] > this.maxAmplitude)
                this.inputAudioStream[i] = (this.maxAmplitude);
            else if(this.inputAudioStream[i] < this.minAmplitude)
                this.inputAudioStream[i] = (this.minAmplitude);
        }
        return this.inputAudioStream;
    }

    // рассчитываем максимальную и минимальную амплитуду
    private void  setMaxAndMinAmpl() {
        this.maxAmplitude = (short) (Envelope.standartMax * this.coef);
        this.minAmplitude = (short) (Envelope.standartMin * this.coef);
    }

    public void setEnvelopeCoef(double coef) {
        this.coef = coef;
    }

    @Override
    public synchronized short[] getOutputAudioStream() {
        return this.inputAudioStream;
    }

}
