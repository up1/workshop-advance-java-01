public class CircularBuffer {
    public static final int DEFAULT_SIZE = 10;
    // Variables
    private String[] buffers;
    private int writePointer;
    private int readPointer;

    // Constructor
    public CircularBuffer() {}

    // Methods
    // Public
    public void create() {
        create(DEFAULT_SIZE);
    }

    public void create(int size) {
        buffers = new String[size];
    }

    public int getSize() {
        return buffers.length;
    }

    public boolean isEmpty() {
        return writePointer - readPointer == 0;
    }

    public void write(String input) {
        buffers[writePointer++] = input;
    }

    public String read() {
        return buffers[readPointer++];
    }

    // Private
}
