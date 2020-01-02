package angels.AngelsConstants;

public enum DarkAngelConstants {
    PYROMANCER_HP(30), KNIGHT_HP(40), ROGUE_HP(10), WIZARD_HP(20);
    private int number;

    DarkAngelConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
