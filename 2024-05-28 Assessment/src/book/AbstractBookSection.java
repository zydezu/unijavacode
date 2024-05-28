package book;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The superclass of all book sections,
 * represents a section of the book.
 */
public abstract class AbstractBookSection {
    public static final int GAME_WON = 0;
    public static final int GAME_LOST = -1;

    int sectionNumber;
    String text;
    Set<Integer> referencedBookSections; // set of choices for reader in section

    /**
     * Constructor for AbstractBookSection, used for super()
     * 
     * @param sectionNumber the section number which must be greater or equal to 1
     * @param text          the section's text
     */
    public AbstractBookSection(int sectionNumber, String text) {
        if (sectionNumber < 1) {
            throw new IllegalArgumentException("sectionNumber must be greater or equal to 1!");
        }
        this.sectionNumber = sectionNumber;
        this.text = text;
        this.referencedBookSections = new HashSet<>();
    }

    // getter
    public int getSectionNumber() {
        return sectionNumber;
    }

    // getter
    public String getText() {
        return text;
    }

    // getter
    public Set<Integer> getReferencedBookSections() {
        return referencedBookSections;
    }

    /**
     * Adds a section's number into the referencedBookSection set, value
     * must be above 0.
     * 
     * @param sectionReference the section number reference to add
     * @return true or false, depending on if sectionReference isn't already
     *         in referencedBookSections
     * @throws InvalidSectionReferenceException thrown if sectionReference
     *                                          is less or equal to 0
     */
    public boolean addBookSectionReference(int sectionReference) throws InvalidSectionReferenceException {
        if (sectionReference <= 0) {
            throw new InvalidSectionReferenceException("sectionReference isn't greater than 0!", sectionReference);
        }
        return referencedBookSections.add(sectionReference);
    }

    /**
     * Returns whether the section is an ending section.
     * 
     * @return true, if ending section, false otherwise
     */
    public abstract boolean isEndingSection();

    /**
     * Executes the section. The execution of the
     * section depends on the type of section.
     * 
     * @param hero the hero who executes this section
     * @return returns the reference of the next section
     *         to read, depending on the execution outcome
     */
    public abstract int executeBookSection(Hero hero);

    int checkExecuteThenRandom(Set<Integer> referencedBookSectionsToCheck) {
        if (referencedBookSectionsToCheck.isEmpty()) {
            throw new IllegalStateException("referencedBookSections is empty!");
        }

        // get random value from set
        int[] sectionsArray = referencedBookSections.stream().mapToInt(Integer::intValue).toArray();
        return sectionsArray[new Random().nextInt(sectionsArray.length)];
    }

    /**
     * A helper method for the constructor, that checks that all the values
     * in the sections are above 0, an InvalidSectionReferenceException
     * error is thrown if this isn't the case.
     * 
     * @param sections a set of all the section numbers a player can choose from
     */
    void checkSectionReferences(int number, Set<Integer> sections) throws InvalidSectionReferenceException {
        checkSectionReferences(number);
        for (int sectionItt : sections) {
            if (sectionItt <= 0) {
                throw new InvalidSectionReferenceException("A value in sections isn't greater than 0!", sectionItt);
            }
        }
    }

    void checkSectionReferences(int number) throws InvalidSectionReferenceException {
        if (number <= 0) {
            throw new InvalidSectionReferenceException("Number is less or equal to 0!", number);
        }
    }
}
