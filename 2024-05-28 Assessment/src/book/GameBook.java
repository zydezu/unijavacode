package book;

import java.util.HashMap;
import java.util.Map;

public class GameBook {
    Hero hero;
    AbstractBookSection start;
    Map<Integer, AbstractBookSection> endings;
    Map<Integer, AbstractBookSection> bookSections;

    public GameBook(Hero hero) {
        this.hero = hero;
        start = null;
        endings = new HashMap<>();
        bookSections = new HashMap<>();
    }

    public void addSection(AbstractBookSection section) throws DuplicateSectionReferenceException {
        int sectionNumber = section.getSectionNumber();
        if (bookSections.containsKey(sectionNumber)) {
            AbstractBookSection existingSection = bookSections.get(sectionNumber);
            if (!existingSection.getText().equals(section.getText())) {
                throw new DuplicateSectionReferenceException(
                        "Section already exists within the book with different text!", sectionNumber);
            }
        }

        if (section.isEndingSection()) {
            endings.put(sectionNumber, section);
        }
        bookSections.put(sectionNumber, section);

    }

    public void setStartingSection(AbstractBookSection start) throws DuplicateSectionReferenceException {
        int sectionNumber = start.getSectionNumber();
        if (start.getSectionNumber() != 1) {
            throw new InvalidSectionReferenceException("Starting section must have the value 1!", sectionNumber);
        }

        if (bookSections.containsKey(sectionNumber)) {
            AbstractBookSection existingSection = bookSections.get(sectionNumber);
            if (!existingSection.getText().equals(start.getText())) {
                throw new DuplicateSectionReferenceException(
                        "Starting section exists with different text!", sectionNumber);
            }
        }

        this.start = start;
        bookSections.put(sectionNumber, start);
    }
}
