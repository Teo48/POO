package angels.AngelsConstants;

public enum LifeGiverConstants {
    PYROMANCER_HP(80), KNIGHT_HP(100), ROGUE_HP(90), WIZARD_HP(120);
    private int number;

    LifeGiverConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
