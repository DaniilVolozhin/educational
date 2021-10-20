package servlets.exception;

public class ArgumentIsNullException extends Exception {
    public ArgumentIsNullException(String massage) {
        super(massage);
    }
}
