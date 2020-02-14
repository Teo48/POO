package players.PlayersConstants;

/**
 * Enum for Knight constants.
 * */
public enum KnightConstants {
    KNIGHT_STARTING_HP(900), KNIGHT_HP_PER_LEVEL(80);
    private int number;

    KnightConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
