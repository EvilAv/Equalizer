package effects;
public abstract class Effect {
    // абстрактный клаас родитель для эффектов
    protected short[] inputAudioStream;
    public abstract short[] createEffect();
    public abstract short[] getOutputAudioStream();
}
