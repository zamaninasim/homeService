package ir.maktab.service.exception;

public class ExpertIsExistException extends RuntimeException {
    public ExpertIsExistException() {
        super("This EmailAddress is Exist!");
    }
}
