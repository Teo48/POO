package skills.KnightSkillsConstants;

public enum ExecuteConstants {
    INIT_EXEC_DAMAGE(200), EXEC_LEVEL_MODIFIER(30), EXEC_MAX_DAMAGE_LEVEL(20),
    STUN_SLAM_TURNS(1), HP_MIN_LIMIT_COEF(0.2f), HP_MAX_LIMIT_COEF(0.4f);
    private int number;
    private float floatNumber;

    ExecuteConstants(int number) {
        this.number = number;
    }

    ExecuteConstants(float floatNumber) {
        this.floatNumber = floatNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public float getFloatNumber() {
        return this.floatNumber;
    }
}
