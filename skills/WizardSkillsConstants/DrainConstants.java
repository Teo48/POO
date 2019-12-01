package skills.WizardSkillsConstants;

/**
 * Enum for drain constants.
 * */

public enum DrainConstants {
    INIT_DRAIN_PROCENT(20), DRAIN_MODIFIER(5), HP_COEF(0.3f), HUNDREAD(100);
    private int number;
    private float floatNumber;

    DrainConstants(final int number) {
        this.number = number;
    }

    DrainConstants(final float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public float getFloatNumber() {
        return this.floatNumber;
    }
}
