package ir.maktab.service.exception;

public class CustomerIsExistException extends RuntimeException {
    public CustomerIsExistException() {
        super("This EmailAddress is Exist!");
    }
}
