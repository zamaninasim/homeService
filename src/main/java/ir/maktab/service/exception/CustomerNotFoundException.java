package ir.maktab.service.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Email or Password is Wrong!");
    }
}
