package skills.KnightSkillsConstants;

public enum SlamConstants {
    INIT_SLAM_DAMAGE(100), SLAM_LEVEL_MODIFIER(40);
    private int number;

    SlamConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
