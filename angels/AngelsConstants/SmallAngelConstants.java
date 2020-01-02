package angels.AngelsConstants;

public enum SmallAngelConstants {
    PYROMANCER_MODIFIER(0.15f), KNIGHT_MODIFIER(0.1f), ROGUE_MODIFIER(0.05f),
    WIZARD_MODIFIER(0.1f), PYROMANCER_HP(15), KNIGHT_HP(10), ROGUE_HP(20), WIZARD_HP(25);
    private float number;
    private int x;

    SmallAngelConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    SmallAngelConstants(final int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
