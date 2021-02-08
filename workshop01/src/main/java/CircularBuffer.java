public class CircularBuffer {
    public static final int DEFAULT_SIZE = 10;
    // Variables
    private String[] buffers;
    private boolean flag = false;

    // Constructor
    public CircularBuffer() {}

    // Methods
    // Public
    public void create() {
        create(DEFAULT_SIZE);
    }

    public void create(int size) {
        buffers = new String[size];
        flag = true;
    }

    public int getSize() {
        return buffers.length;
    }

    public boolean isEmpty() {
        return flag;
    }

    // Private
}
