package skills.KnightSkillsConstants;

/**
 * Enum for players' modifiers.
 * */

public enum PlayersModifiers {
    PYRO_EXECUTE_MODIFIER(1.1f), PYRO_SLAM_MODIFIER(0.9f), KNIGHT_EXECUTE_MODIFIER(1.0f),
    KNIGHT_SLAM_MODIFIER(1.2f), ROGUE_EXECUTE_MODIFIER(1.15f), ROGUE_SLAM_MODIFIER(0.8f),
    WIZARD_EXECUTE_MODIFIER(0.8f), WIZARD_SLAM_MODIFIER(1.05f);
    private float number;

    PlayersModifiers(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return this.number;
    }
}
