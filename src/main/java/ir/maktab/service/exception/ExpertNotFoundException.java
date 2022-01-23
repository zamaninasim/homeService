package ir.maktab.service.exception;

public class ExpertNotFoundException extends RuntimeException {
    public ExpertNotFoundException() {
        super("Email or Password is Wrong!");
    }
}
