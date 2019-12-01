package players.PlayersConstants;

/**
 * Enum for Pyromancer constants.
 * */

public enum PyromancerConstants {
    PYROMANCER_STARTING_HP(500), PYROMANCER_HP_PER_LEVEL(50);
    private int number;

    PyromancerConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
