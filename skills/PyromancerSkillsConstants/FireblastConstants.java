package skills.PyromancerSkillsConstants;

/**
 * Enum for Fireblast constants.
*/
public enum FireblastConstants {
    INIT_FB_DAMAGE(350), FB_MODIFIER(50);
    private int number;

    FireblastConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
