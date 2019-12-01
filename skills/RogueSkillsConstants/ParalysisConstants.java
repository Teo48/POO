package skills.RogueSkillsConstants;

/**
 * Enum for paralysis constants.
 * */

public enum ParalysisConstants {
    INIT_PARALYSIS_DAMAGE(40), PARALYSIS_DAMAGE_MODIFIER(10), NORMAL_STUNNED_TUNRS(3),
    EXTRA_STUNNED_TURNS(6);
    private int number;

    ParalysisConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

}
