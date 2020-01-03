package angels.AngelsConstants;

/**
 * Enum for Spawner's constants.
 * */
public enum SpawnerConstants {
    PYROMANCER_HP(150), KNIGHT_HP(200), ROGUE_HP(180), WIZARD_HP(120);
    private int number;

    SpawnerConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
