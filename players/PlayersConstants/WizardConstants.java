package players.PlayersConstants;

/**
 * Enum for Wizard constants.
 * */

public enum WizardConstants {
    WIZARD_STARTING_HP(400), WIZARD_HP_PER_LEVEL(30);
    private int number;

    WizardConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
