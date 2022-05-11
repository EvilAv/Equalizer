package effects;

public class Vibrato extends Effect {

    private short maxAmplitude;
    private short minAmplitude;
    private static final short standartMax = 350;
    private static final short standartMin = -350;
    private double coef;

    public Vibrato() {
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
//        float vi_cof = 0.9F;
//        boolean flag = true;
//        int position = 0;
//        for (int i = 5000; i < (this.inputAudioStream.length); i++) {
//            this.inputAudioStream[position] = (short)(this.inputAudioStream[i] * vi_cof);
//            if (position % 500 == 0){
//                if (flag)
//                    vi_cof += 0.001f;
//                else
//                    vi_cof -= 0.001f;
//                if (vi_cof == 1.0f)
//                    flag = false;
//                if (vi_cof == 0.9f)
//                    flag = true;
//            }
//            position++;
//        }
        // если исходный сигнал опускается выше или ниже заданных границ,то приравниваем амплитуды к значению границы
        // иными словами как бы обрезаем синусоиду
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
        this.maxAmplitude = (short) (Vibrato.standartMax * this.coef);
        this.minAmplitude = (short) (Vibrato.standartMin * this.coef);
    }

    public void setVibratoCoef(double coef) {
        this.coef = coef;
    }

    @Override
    public synchronized short[] getOutputAudioStream() {
        return this.inputAudioStream;
    }

}
