package skills.PyromancerSkillsConstants;

public enum FireblastConstants {
    INIT_FB_DAMAGE(350), FB_MODIFIER(50);
    private int number;

    FireblastConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
