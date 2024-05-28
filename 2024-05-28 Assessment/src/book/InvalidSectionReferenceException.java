package book;

public class InvalidSectionReferenceException extends RuntimeException {
    int sectionReference;

    public InvalidSectionReferenceException(String message, int sectionReference) {
        super(message);
        this.sectionReference = sectionReference;
    }
}
