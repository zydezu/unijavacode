package book;

/**
 * A class representing the hero (the player/reader of the eBook).
 */
public class Hero {
    String name;
    int maxAbility;
    int maxHealth;
    int ability;
    int health;

    /**
     * @param name       the hero's name
     * @param maxAbility the maximum ability value the hero can have
     * @param maxHealth  the maximum health of the hero, the health variable
     *                   shouldn't be above this.
     * @throws IllegalArgumentException occurs if health becomes a value that is
     *                                  below 0
     *                                  or ability is below 1
     */
    public Hero(String name, int maxAbility, int maxHealth) throws IllegalArgumentException {
        if (maxAbility < 4 || maxHealth < 4) {
            throw new IllegalArgumentException("maxAbility or maxHealth is not above 4!");
        }

        this.name = name;
        this.maxAbility = maxAbility;
        this.maxHealth = maxHealth;

        health = maxHealth;
        ability = maxAbility - 3;
    }

    // getters for variables
    public String getName() {
        return name;
    }

    public int getMaxAbility() {
        return maxAbility;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAbility() {
        return ability;
    }

    public int getHealth() {
        return health;
    }

    /**
     * Adds the specified amount to the current ability,
     * has an upper limit of maxAbility (ability won't rise
     * above maxAbility).
     * 
     * @param gain the amount to increase ability by
     */
    public void gainAbility(int gain) {
        ability += gain;
        if (ability > maxAbility) {
            ability = maxAbility;
        }
    }

    /**
     * Decreases ability by the specified amount,
     * applys a lower limit of 1 (ability won't fall below 1).
     * 
     * @param loss the amount to decrease ability by
     */
    public void loseAbility(int loss) {
        ability -= loss;
        if (ability < 1) {
            ability = 1;
        }
    }

    /**
     * Decreases health by a specified value, health can't go below 0.
     * 
     * @param seriousness the amount to subtract from health
     */
    public void receiveInjury(int seriousness) {
        health -= seriousness;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * The amount health is changed by,
     * health can't be above the maxHealth variable,
     * nor below zero, since the bonus can be positive
     * (health potion) or negative (poison).
     * 
     * @param bonus the amount health is changed by
     */
    public void addHealthBonus(int bonus) {
        health += bonus;
        if (health > maxHealth) {
            health = maxHealth;
        } else if (health < 0) {
            health = 0;
        }
    }
}
