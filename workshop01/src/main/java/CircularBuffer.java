import static java.lang.System.out;

public class CircularBuffer {
    private String[] buffers;

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer();
        // Create buffer : default size = 10
        circularBuffer.create();
        // Size of buffer
        int size = circularBuffer.getSize();
        out.println(size);
    }

    private int getSize() {
        return buffers.length;
    }

    private void create() {
        buffers = new String[10];
    }
}
