package dao.exception;

public class ProfileNotFoundException extends Exception {
    public ProfileNotFoundException(String massage) {
        super(massage);
    }
}
