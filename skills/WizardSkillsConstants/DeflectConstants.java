package skills.WizardSkillsConstants;

public enum DeflectConstants {
    INIT_DEFLECT_PROCENT(35), DEFlECT_MODIFIER(2), MAX_PROC(70), HUNDREAD(100);
    private int number;
    private float floatNumber;

    DeflectConstants(int number) {
        this.number = number;
    }

    DeflectConstants(float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public float getFloatNumber() {
        return this.floatNumber;
    }
}
