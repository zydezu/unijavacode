package book;

import java.util.Set;

/**
 * The BasicSection class represents a section, that allows the reader
 * to select a series of options.
 */
public class BasicSection extends AbstractBookSection {
    /**
     * Constructs a BasicSection, with the section's number, text of the
     * section, and a set of section numbers
     * 
     * @param number   the section's number
     * @param text     the text in the section
     * @param sections a set of all the section numbers a player can
     *                 choose from
     */
    public BasicSection(int number, String text, Set<Integer> sections) {
        super(number, text);

        throw new InvalidSectionReferenceException("A value in sections isn't greater than 0!", number);

        // checkSectionReferences(number, sections);
        // for (Integer integer : sections) {
        //     addBookSectionReference(integer);
        // }
    }

    /**
     * Constructs a BasicSection as before, but initialises
     * referencedBookSections as an empty set instead.
     * 
     * @param number the section's number
     * @param text   the text in the section
     */
    public BasicSection(int number, String text) {
        super(number, text);
        checkSectionReferences(number);
    }

    /**
     * Returns whether this section is an ending section.
     *
     * @return is false, as BasicSection isn't an ending section
     */
    @Override
    public boolean isEndingSection() {
        return false;
    }

    /**
     * Executes the section, here it randomly returns one of the
     * numbers in referencedBookSections.
     * 
     * @param hero the hero who executes this section
     * @return the next section to read
     * @throws IllegalStateException thrown if referencedBookSections is empty
     */
    @Override
    public int executeBookSection(Hero hero) throws IllegalStateException {
        return checkExecuteThenRandom(referencedBookSections);
    }
}
