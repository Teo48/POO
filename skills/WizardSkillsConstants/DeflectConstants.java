package skills.WizardSkillsConstants;

/**
 * Enum for deflect constants.
 * */

public enum DeflectConstants {
    INIT_DEFLECT_PROCENT(35), DEFlECT_MODIFIER(2), MAX_PROC(70), HUNDREAD(100);
    private int number;

    DeflectConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
