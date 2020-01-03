package players;
import angels.Angel;
import strategies.Strategy;
import skills.SkillsVisitor;
import utils.Coordinates;
import observers.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class to define a Hero.
 * This class will be extened.
 * */

public abstract class Hero {
    private Coordinates coordinates;
    private int xp;
    private int hp;
    private int id;
    private int maxHp;
    private int level;
    private int stunnedTurns;
    private int passiveDamage;
    private int backstab = 0;
    private int passiveCounter = 0;
    private boolean isDead;
    private float angelModifier;
    private Strategy strategy;
    private List<Observer> observers = new LinkedList<>();

    /**
     * Constructor.
     * @param c -> Coordinates - player's position.
     * */
    public Hero(final Coordinates c) {
        this.coordinates = c;
        this.isDead = false;
        this.stunnedTurns = 0;
        this.xp = 0;
        this.level = 0;
        this.passiveDamage = 0;
    }

    /**
     * Move method.
     * @param dx -> direction on x axis.
     * @param dy -> direction on y axis.
     * */
    public final void move(final int dx, final int dy) {
        if (isDead || stunnedTurns > 0) {
            --stunnedTurns;
            return;
        }

        coordinates.setX(coordinates.getX() + dx);
        coordinates.setY(coordinates.getY() + dy);
    }

    /**
     * Gain XP method.
     * @param enemyLevel -> enemy's level.
     * */
    public final void gainXp(final int enemyLevel) {
        this.xp += Math.max(0, HeroConstants.BASE_XP_GAIN.getNumber() - (this.level
            - enemyLevel) * (HeroConstants.GAIN_XP_PER_LEVEL.getNumber()));
        calculateLevel();
    }

    /**
     * Method used for computing player's next level and notifying the GrandMagician.
     * It also sets player's hp and max hp.
     * */
    public final void calculateLevel() {
        while (this.xp >= HeroConstants.BASE_XP.getNumber()
                + this.level * HeroConstants.XP_PER_LEVEL.getNumber()) {
            ++this.level;
            StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getSimpleName()).append(" ").append(this.getId())
                    .append(" reached level ").append(this.level);
            this.notifyAll(sb.toString());
            this.hp = getMaxHpLevelUp();
            this.maxHp = this.hp;
        }
    }

    /**
     * Computes player's needed xp for leveling up.
     * */
    public final void nextLevelXp() {
        int nextLevelXp = HeroConstants.BASE_XP.getNumber()
                + this.level * HeroConstants.XP_PER_LEVEL.getNumber();
        this.xp += nextLevelXp - this.xp;
        calculateLevel();
    }

    public final void addXp(final int xpValue) {
        this.xp += xpValue;
        calculateLevel();
    }
    /**
     * Method used for applying the passive damage.
     * If the player is alive and the passiveCounter is higher than 0 he takes the passiveDamage.
     * If his hp goes below 0, the isDead tag is set true and then we return from the method.
     * */
    public final void getPassiveDamage() {
        if (!this.isDead && this.passiveCounter != 0) {
                this.hp -= this.passiveDamage;
                if (this.hp <= 0) {
                    this.isDead = true;
                    return;
                }
                --this.passiveCounter;
        }
    }

    /**
     * @param passiveCnt -> The number of rounds for the passive damage.
     * @param passiveDmg -> Passive damage.
     * */
    public final void setPassiveDamage(final int passiveCnt, final int passiveDmg) {
        this.passiveCounter = passiveCnt;
        this.passiveDamage = passiveDmg;
    }

    /**
     * Method used for applying the active damage.
     * @param damage -> Damage value.
     * If player's hp goes below 0, the isDead tag is set true.
     * */
    public final void getActiveDamage(final int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            isDead = true;
        }
    }

    /**
     * This method will be overriden.
     * @return int -> Maximum hp that a player has after leveling-up.
     * */
    public int getMaxHpLevelUp() {
        return 0;
    }

    /**
     * Increase player's hp with hitPoints value. The resulted value cannot be bigger than player's
     * maxHp.
     * @param hitPoints
     * */
    public final void gainHp(final int hitPoints) {
        this.hp = (this.hp + hitPoints) > this.maxHp ? this.maxHp : (this.hp + hitPoints);
    }

    public final void setStrategy(final Strategy st) {
        this.strategy = st;
    }

    public final Strategy getStrategy() {
        return strategy;
    }

    /**
     * This method will be overriden.
     * @return int -> Maximum hp that a player has.
     * */
    public final int getMaxHp() {
        return maxHp;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int getId() {
        return id;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    /**
     * It substracts hitPoints from player's HP. If the player is killed, the GrandMagician
     * is notified.
     * @param hitPoints
     * */
    public final void takeHp(final int hitPoints) {
        this.hp -= hitPoints;

        if (this.hp <= 0) {
            kill();
            StringBuilder sb = new StringBuilder();
            sb.append("Player ").append(this.getClass().getSimpleName()).append(" ")
                    .append(this.getId()).append(" was killed by an angel");
            notifyAll(sb.toString());
        }
    }

    public final void revive() {
        this.isDead = false;
    }

    public final void kill() {
        this.isDead = true;
    }

    public final void setBackstab(final int bcstb) {
        this.backstab = bcstb;
    }

    public final int getBackstab() {
        return backstab;
    }

    public final boolean isDead() {
        return isDead;
    }

    public final void setMaxHp(final int maxHp) {
        this.maxHp = maxHp;
    }

    public final void setStunnedTurns(final int stunnedTurns) {
        this.stunnedTurns = stunnedTurns;
    }

    public final int getStunnedTurns() {
        return stunnedTurns;
    }

    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final int getLevel() {
        return level;
    }

    public final int getHp() {
        return hp;
    }

    public final int getXp() {
        return xp;
    }

    public final List<Observer> getObservers() {
        return observers;
    }

    /**
     * Method used by a hero when choosing a strategy.
     * This method will be overriden.
     * */
    public abstract void pickStrategy();
    public abstract void addObserver(Observer observer);
    public abstract void notifyAll(String str);
    /**
     *Accept method.
     * @param skill -> Visit accept method.
    */
    public abstract void accept(SkillsVisitor skill);

    /**
     * Accept method for an angel.
     * @param angel
     * */
    public abstract void acceptAngel(Angel angel);

    /**
     * @return SkillsVisitor -> Visitor.
     * */
    public abstract SkillsVisitor heroSkill();

    /**
     * @return String -> It has the following format:
     *  -> className.charAt(0) + "dead" if the player is dead.
     *  -> className.charAt(0) + player xp + player hp + player coordinates.
     * */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName().charAt(0)).append(" ");

        if (this.isDead) {
            stringBuilder.append("dead");
            return stringBuilder.toString();
        }

        stringBuilder.append(this.getLevel()).append(" ").append(this.getXp())
                .append(" ").append(this.getHp()).append(" ").append(this.coordinates.getX())
                .append(" ").append(this.coordinates.getY());

        return stringBuilder.toString();
    }

    /**
     * It stores the modifiers when a player is visited by an angel.
     * By doing that, we are able to change player's modifiers by passing the angelModifier.
     * @param data
     * */
    public void setAngelModifier(final float data) {
        this.angelModifier += data;
    }

    /**
     * Returns player's angelModifiers.
     * @return float
     * */
    public float getAngelModifier() {
        return this.angelModifier;
    }
}

