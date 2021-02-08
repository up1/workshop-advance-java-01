import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();

    @Test
    public void read_data_from_empty_buffer_then_throw_exception() {
        circularBuffer.create();
        writeDataToBuffer("A", "B");
        // JUnit 5
        Exception exception = assertThrows(EmptyBufferException.class, () -> {
            circularBuffer.read();
            circularBuffer.read();
            circularBuffer.read();
        });
        assertNotNull(exception);
        assertEquals("Buffer is empty", exception.getMessage());
    }

    @Test
    public void write_A_B_and_read_A_B_then_buffer_is_empty() {
        circularBuffer.create();
        writeDataToBuffer("A", "B");
        circularBuffer.read();
        circularBuffer.read();
        assertTrue(circularBuffer.isEmpty());
    }

    private void writeDataToBuffer(String... inputs) {
        for (String input : inputs) {
            circularBuffer.write(input);
        }
    }

    @Test
    public void write_A_B_should_read_A_B() {
        circularBuffer.create();
        writeDataToBuffer("A", "B");
        assertEquals("A", circularBuffer.read());
        assertEquals("B", circularBuffer.read());
    }

    @Test
    public void write_A_should_read_A() {
        circularBuffer.create();
        writeDataToBuffer("A");
        String result = circularBuffer.read();
        assertEquals("A", result);
    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้วเพิ่มข้อมูลเข้าไป ผลที่ได้ buffer ต้องไม่ว่าง")
    public void after_created_and_write_data_should_be_not_empty() {
        circularBuffer.create();
        writeDataToBuffer("A");
        boolean status = circularBuffer.isEmpty();
        assertFalse(status);
    }

    @Test
    @DisplayName("หลังจากสร้าง buffer แล้ว buffer จะต้องว่างเสมอ")
    public void after_created_should_be_empty() {
        circularBuffer.create();
        boolean status = circularBuffer.isEmpty();
        assertTrue(status);
    }

    @Test
    @DisplayName("ขนาดของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specified_size_5() {
        // Act
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }

    @Test
    @DisplayName("ขนาด default ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size() {
        // Act
        circularBuffer.create();
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

}