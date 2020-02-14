package angels.AngelsConstants;

/**
 * Enum for XPAngel's constants.
 * */
public enum XPAngelConstants {
    PYROMANCER_XP(50), KNIGHT_XP(45), ROGUE_XP(40), WIZARD_XP(60);
    private int number;

    XPAngelConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
