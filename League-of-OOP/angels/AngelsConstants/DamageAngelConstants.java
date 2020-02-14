package angels.AngelsConstants;

/**
 * Enum for DamageAngel's constants.
 * */
public enum DamageAngelConstants {
    PYROMANCER_MODIFIER(0.2f), KNIGHT_MODIFIER(0.15f), ROGUE_MODIFIER(0.3f), WIZARD_MODIFIER(0.4f);
    private float number;

    DamageAngelConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }
}
