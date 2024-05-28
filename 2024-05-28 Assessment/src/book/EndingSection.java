package book;

public class EndingSection extends AbstractBookSection {
    boolean winsGame;

    public EndingSection(int number, String text, boolean winsGame) {
        super(number, text);
        checkSectionReferences(number);
        this.winsGame = winsGame;
    }

    public EndingSection(int number, String text) {
        this(number, text, true);
    }

    @Override
    public boolean isEndingSection() {
        return true;
    }

    @Override
    public int executeBookSection(Hero hero) throws IllegalStateException {
        return winsGame ? GAME_WON : GAME_LOST;
    }

    @Override
    public boolean addBookSectionReference(int sectionReference) {
        throw new UnsupportedOperationException("Tried to add a section to EndingSections!");
    }
}
