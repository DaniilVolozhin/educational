package exception;

public class DaoSystemException extends Exception {
    public DaoSystemException(String massage, Exception e) {
        super(massage);
    }
}
