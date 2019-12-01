package skills.PyromancerSkillsConstants;

/**
 * Enum for pyro players' modifiers.
 * */
public enum PlayersModifiers {
    PYRO_MODIFIER(0.9f), KNIGHT_MODIFIER(1.2f), WIZARD_MODIFIER(1.05f), ROGUE_MODIFIER(0.8f);
    private float number;

    PlayersModifiers(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return this.number;
    }
}
