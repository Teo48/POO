package players;
import skills.SkillsVisitor;
import utils.Coordinates;

/**
 * Abstract class to define a Hero.
 * This class will be extened.
 * */

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

        while (this.xp >= HeroConstants.BASE_XP.getNumber()
                + this.level * HeroConstants.XP_PER_LEVEL.getNumber()) {
            ++this.level;
            this.hp = getMaxHpLevelUp();
        }
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
     * This method will be overriden.
     * @return int -> Maximum hp that a player has.
     * */
    public int getMaxHp() {
        return maxHp;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
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

    /**
     *Accept method.
     * @param skill -> Visit accept method.
    */
    public abstract void accept(SkillsVisitor skill);

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
        stringBuilder.append(this.getClass().getSimpleName().charAt(0) + " ");

        if (this.isDead) {
            stringBuilder.append("dead");
            return stringBuilder.toString();
        }

        stringBuilder.append(this.getLevel() + " " + this.getXp() + " " + this.getHp() + " "
            + this.coordinates.getX() + " " + this.coordinates.getY());

        return stringBuilder.toString();
    }
}

