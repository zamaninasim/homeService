package ir.maktab.service.exception;

public class MainServiceIsExistException extends RuntimeException {
    public MainServiceIsExistException() {
        super("This MainService is Exist!");
    }
}
