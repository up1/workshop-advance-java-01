public class CircularBuffer {
    public static final int DEFAULT_SIZE = 10;
    // Variables
    private String[] buffers;

    // Constructor
    public CircularBuffer() {}

    // Methods
    // Public
    public void create() {
        buffers = new String[DEFAULT_SIZE];
    }

    public int getSize() {
        return buffers.length;
    }

    // Private
}
