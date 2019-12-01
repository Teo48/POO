package skills.WizardSkillsConstants;

/**
 * Enum for wizzard constants.
 * */
public enum PlayersModifiers {
    PYRO_ATTACK_MODIFIER(1.3f), KNIGHT_ATTACK_MODIFIER(1.4f), ROGUE_ATTACK_MODIFIER(1.2f),
    PYRO_DRAIN_MODIFIER(0.9f), KNIGHT_DRAIN_MODIFIER(1.2f), ROGUE_DRAIN_MODIFIER(0.8f),
    WIZARD_DRAIN_MODIFIER(1.05f);
    private float number;

    PlayersModifiers(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return this.number;
    }
}
