package angels.AngelsConstants;

/**
 * Enum for Dracula's constants.
 * */
public enum DraculaConstants {
    PYROMANCER_MODIFIER(-0.3f), KNIGHT_MODIFIER(-0.2f), ROGUE_MODIFIER(-0.1f),
    WIZARD_MODIFIER(-0.4f), PYROMANCER_HP(40), KNIGHT_HP(60), ROGUE_HP(35), WIZARD_HP(20);
    private float number;
    private int x;

    DraculaConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    DraculaConstants(final int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
