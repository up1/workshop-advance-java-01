public class EmptyBufferException extends RuntimeException{

    public EmptyBufferException() {
        super("Buffer is empty");
    }

}

class BusinessException extends RuntimeException {
    public int code;
    public String message;

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
