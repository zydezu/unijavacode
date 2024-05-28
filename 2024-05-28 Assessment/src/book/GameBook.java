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
}
