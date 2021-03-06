package skills.RogueSkillsConstants;

/**
 * Enum for players' modifiers.
 * */
public enum PlayersModifiers {
    PYRO_BACKSTAB_MODIFIER(1.25f), PYRO_PARALYSIS_MODIFIER(1.2f), KNIGHT_BACKSTAB_MODIFIER(0.9f),
    KNIGHT_PARALYSIS_MODIFIER(0.8f), ROGUE_BACKSTAB_MODIFIER(1.2f), ROGUE_PARALYSIS_MODIFIER(0.9f),
    WIZARD_BACKSTAB_MODIFIER(1.25f), WIZARD_PARALYSIS_MODIFIER(1.25f);
    private float number;

    PlayersModifiers(final float number) {
        this.number = number;
    }

    public float getNumber(final float x) {
        return this.number + x;
    }
}
