package skills.PyromancerSkillsConstants;

public enum IgniteConstants {
    INIT_IGNITE_DAMAGE(150), IGNITE_DAMAGE_MODIFIER(20), INIT_IGNITE_PASSIVE(50),
    PASSIVE_COUNTER(2), IGNITE_PASSIVE_MODIFIER(30);
    private int number;

    IgniteConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
