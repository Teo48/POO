package strategies;

public enum StrategiesConstants {
    PYROMANCER_ATTACK_MODIFIER(0.7f), PYROMANCER_DEFENSE_MODIFIER(-0.3f),
    KNIGHT_ATTACK_MODIFIER(0.5f), KNIGHT_DEFENSE_MODIFIER(-0.2f), ROGUE_ATTACK_MODIFIER(0.4f),
    ROGUE_DEFENSE_MODIFIER(-0.1f), WIZARD_ATTACK_MODIFIER(0.6f), WIZARD_DEFENSE_MODIFIER(-0.2f),
    PYROMANCER_HP_ATTACK(4), PYROMANCER_HP_DEFENSE(3), KNIGHT_ATTACK_HP(5), ROGUE_ATTACK_HP(7),
    ROGUE_DEFENSE_HP(2), KNIGHT_DEFENSE_HP(4), WIZARD_ATTACK_HP(10), WIZARD_DEFENSE_HP(5);
    private float number;
    private int x;

    StrategiesConstants(final float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    StrategiesConstants(final int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
