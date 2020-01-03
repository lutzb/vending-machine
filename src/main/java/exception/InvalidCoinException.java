package main.java.exception;

public class InvalidCoinException extends VendingMachineException {

    public InvalidCoinException(String message) {
        super(message);
    }
}
