package players;
import skills.AttackVisitor;
import utils.Coordinates;

public abstract class Hero {
    private Coordinates coordinates;
    private int xp;
    private int hp;
    private int maxHp;
    private int level;
    private int stunnedTurns;
    private int passiveDamage;
    private int backstab = 0;
    private int passiveCounter = 0;
    private boolean isDead;

    public Hero(final Coordinates c) {
        this.coordinates = c;
        this.isDead = false;
        this.stunnedTurns = 0;
        this.xp = 0;
        this.level = 0;
        this.passiveDamage = 0;
    }

}
