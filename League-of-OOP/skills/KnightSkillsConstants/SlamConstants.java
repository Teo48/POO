package skills.KnightSkillsConstants;

/**
 * Enum for slam constants.
 * */
public enum SlamConstants {
    INIT_SLAM_DAMAGE(100), SLAM_LEVEL_MODIFIER(40);
    private int number;

    SlamConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
