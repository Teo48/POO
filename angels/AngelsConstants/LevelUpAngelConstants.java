package angels.AngelsConstants;

public enum LevelUpAngelConstants {
    PYROMANCER_MODIFIER(0.2f), KNIGHT_MODIFIER(0.1f), ROGUE_MODIFIER(0.15f), WIZARD_MODIFIER(0.25f);
    private float number;

    LevelUpAngelConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }
}
