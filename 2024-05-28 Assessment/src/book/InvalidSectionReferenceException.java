package book;

public class InvalidSectionReferenceException extends RuntimeException {
    private int sectionReference;

    public InvalidSectionReferenceException(String message, int sectionReference) {
        super(message);
        this.sectionReference = sectionReference;
    }

    public int getSectionReference() {
        return sectionReference;
    }
}
