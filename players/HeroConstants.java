package players;

/**
 * Enum for Hero constants.
 * */
public enum HeroConstants {
    BASE_XP(250), BASE_XP_GAIN(200), GAIN_XP_PER_LEVEL(40), XP_PER_LEVEL(50);

    private int number;

    HeroConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
