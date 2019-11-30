package skills.RogueSkillsConstants;

public enum ParalysisConstants {
    INIT_PARALYSIS_DAMAGE(40), PARALYSIS_DAMAGE_MODIFIER(10), NORMAL_STUNNED_TUNRS(3),
    EXTRA_STUNNED_TURNS(6);
    private int number;
    private float floatNumber;

    ParalysisConstants(int number) {
        this.number = number;
    }

    ParalysisConstants(float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public float getFloatNumber() {
        return this.floatNumber;
    }
}
