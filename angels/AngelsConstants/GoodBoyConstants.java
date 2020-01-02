package angels.AngelsConstants;

public enum GoodBoyConstants {
    PYROMANCER_MODIFIER(0.5f), KNIGHT_MODIFIER(0.4f), ROGUE_MODIFIER(0.4f),
    WIZARD_MODIFIER(0.3f), PYROMANCER_HP(30), KNIGHT_HP(20), ROGUE_HP(40), WIZARD_HP(50);
    private float number;
    private int x;

    GoodBoyConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    GoodBoyConstants(final int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
