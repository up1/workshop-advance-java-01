public class CircularBuffer {
    public static final int DEFAULT_SIZE = 10;
    // Variables
    private String[] buffers;

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

    // Private
}
