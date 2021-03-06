package utils;

/**
 * Constants for land modifiers.
 * */
public enum LandModifiers {
    PYRO_LAND_MODIFIER(1.25f), KNIGHT_LAND_MODIFIER(1.15f), ROGUE_LAND_MODIFIER(1.15f),
    WIZARD_LAND_MODIFIER(1.1f);
    private float number;

    LandModifiers(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return this.number;
    }
}
