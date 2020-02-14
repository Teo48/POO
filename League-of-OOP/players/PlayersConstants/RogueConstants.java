package players.PlayersConstants;

/**
 * Enum for Rogue constants.
 * */

public enum RogueConstants {
    ROGUE_STARTING_HP(600), ROGUE_HP_PER_LEVEL(40);
    private int number;

    RogueConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
