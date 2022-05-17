package equalizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Equalizer {

    private short[] inputSignal;
    private short[] outputSignal;
    private final static char COUNT_OF_THREADS = 4;
    private final int lenghtOfInputSignal;
    ExecutorService pool;

    // конструктор класса, задает размер входящего сигнла и количество потоков
    public Equalizer(final int lenghtOfInputSignal) {

        pool = Executors.newFixedThreadPool(COUNT_OF_THREADS);
        this.lenghtOfInputSignal = lenghtOfInputSignal;
    }

    // формируем входной и выходной сигналы
    public void setInputSignal(short[] inputSignal) {
        this.inputSignal = inputSignal;
        this.outputSignal = new short[this.lenghtOfInputSignal];
    }


    // работа эквалайзера
    public void equalization( ) throws InterruptedException, ExecutionException {
        // алгоритм формирвоания выходного сигнала после фильрации сигнала
        for(int i = 0; i < this.outputSignal.length; i++) {
            this.outputSignal[i] += this.inputSignal[i];
        }
    }


    // получить выходной сигнал
    public short[] getOutputSignal() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
        }
        return this.outputSignal;
    }

    // заверешение работы
    public void close() {
        if(this.pool != null) {
            this.pool.shutdown();
        }
    }
}