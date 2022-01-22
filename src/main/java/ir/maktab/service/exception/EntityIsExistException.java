package ir.maktab.service.exception;

public class EntityIsExistException extends RuntimeException {
    public EntityIsExistException(String message) {
        super(message);
    }
}
