package ir.maktab.service.exception;

public class ManagerNotFoundException extends RuntimeException {
    public ManagerNotFoundException() {
        super("Email or Password is Wrong!");
    }
}
