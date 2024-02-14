package exception;

public class NoSuchProductException extends Exception {
    public NoSuchProductException(String massage) {
        super(massage);
    }
}
