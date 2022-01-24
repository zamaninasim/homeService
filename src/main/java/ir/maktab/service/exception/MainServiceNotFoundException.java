package ir.maktab.service.exception;

public class MainServiceNotFoundException extends RuntimeException {
    public MainServiceNotFoundException() {
        super("mainService not found!");
    }
}
