package servlets.exception;

public class ArgumentIsNoCorrectException extends Exception {
    public ArgumentIsNoCorrectException(String massage) {
        super(massage);
    }
}
