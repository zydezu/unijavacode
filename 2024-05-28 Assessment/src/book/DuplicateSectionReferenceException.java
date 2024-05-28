package book;

public class DuplicateSectionReferenceException extends Exception {
    int sectionReference;

    public DuplicateSectionReferenceException(String message, int sectionReference) {
        super(message);
        this.sectionReference = sectionReference;
    }
}
