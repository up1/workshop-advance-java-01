import static java.lang.System.out;

public class CircularBuffer {
    private String[] buffers;

    public int getSize() {
        return buffers.length;
    }

    public void create() {
        buffers = new String[10];
    }
}
