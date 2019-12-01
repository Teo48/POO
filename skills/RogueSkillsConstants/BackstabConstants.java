package skills.RogueSkillsConstants;

/**
 * Enum for backstab constants.
 * */

public enum BackstabConstants {
    BACKSTAB_INIT_DAMAGE(200), BACKSTAB_LEVEL_MODIFIER(20), CRITICAL_HIT(3),
    BACKSTAB_CRITICAL_HIT_COEF(1.5f);
    private int number;
    private float floatNumber;

    BackstabConstants(final int number) {
        this.number = number;
    }

    BackstabConstants(final float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public float getFloatNumber() {
        return this.floatNumber;
    }
}
