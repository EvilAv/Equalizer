package player;

public class RingBuf {
    // массив, где непосредственно будут храниться значения
    private byte[] buffer;
    // размер массива
    private final int size;
    // указатели на начало и конец кольцевого буфера
    private int head;
    private int tail;
    // флаг блокировки кольцевого буфера
    private boolean isLocked;
    // флаг, означающий, что данные перестали поступать в кольцевой буфер
    private boolean isStopUpdateData;

    public RingBuf(int size) {
        this.size = size;

        // начальные значение
        head = -1;
        tail = -1;

        isStopUpdateData = false;

        buffer = new byte[size];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        if (head == 0 && tail == size - 1)
            return true;

        return head == (tail + 1);
    }

    // вставка новго элемента в начало
    public void push(byte data) throws Exception {
        if (isFull())
            throw new Exception("The queue is full. You're need to clear the data");
        else {
            if (head == -1) {
                head = 0;
            }

            tail = (tail + 1) % size;
            buffer[tail] = data;
        }
    }

    // получаем первый элемент и удаляем его
    public byte pop() throws Exception {
        if (isEmpty())
            throw new Exception("The queue is empty. You're need to add the data");
        else {
            byte result = buffer[head];
            if (head == tail) { // если извлекли последний элемент
                head = -1;
                tail = -1;
            } else
                head = (head + 1) % size;

            return result;
        }

    }
    // буфер считается заблокированным если запись в буфер остановлена и буфер пустой
    public boolean isLocked() {
        return (isStopUpdateData && isEmpty());
    }

    public boolean isStopUpdateData() {
        return isStopUpdateData;
    }

    // останавливаем запись в буфер
    public void stopUpdate() {
        isStopUpdateData = true;
    }

    public int getSize() {
        return size;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
