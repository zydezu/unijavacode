package book;

import java.util.Set;

/**
 * The HealthBonusSection class represents a section of the book
 * that affects the health of the hero, and may offer several
 * options to read for their next move.
 */
public class HealthBonusSection extends AbstractBookSection {
    int bonus;

    /**
     * Constructs a HealthBonusSection, with the section's number, text,
     * bonus, and a set of referenced sections.
     * 
     * @param number   the section number, must be greater than 0
     * @param text     the text in the section
     * @param sections a set of all the section numbers a player can
     *                 choose from
     * @param bonus    the health bonus
     * @throws InvalidSectionReferenceException thrown if number or any value in
     *                                          sections
     *                                          is less than or equal to 0
     */
    public HealthBonusSection(int number, String text,
            Set<Integer> sections, int bonus) {
        super(number, text);
        checkSectionReferences(number, sections);
        this.bonus = bonus;
        for (Integer integer : sections) {
            addBookSectionReference(integer);
        }
    }

    /**
     * Returns whether this section is an ending section.
     *
     * @return is false, as HealthBonusSection isn't an ending section
     */
    @Override
    public boolean isEndingSection() {
        return false;
    }

    /**
     * Executes the section, here it modifies the health of the hero,
     * and if the hero is still alive, randomly returns one of the
     * numbers in referencedBookSections.
     * 
     * @param hero the hero who executes this section
     * @return the next section to read
     * @throws IllegalStateException thrown if referencedBookSections is empty
     */
    @Override
    public int executeBookSection(Hero hero) throws IllegalStateException {
        hero.addHealthBonus(bonus);
        if (hero.getHealth() <= 0) {
            return GAME_LOST;
        }
        return checkExecuteThenRandom(referencedBookSections);
    }

}
