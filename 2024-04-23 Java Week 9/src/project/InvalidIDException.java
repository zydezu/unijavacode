package project;

public class InvalidIDException extends Exception {
    public InvalidIDException() {}; 

    public InvalidIDException(String message) {
        super(message);
    }
}
