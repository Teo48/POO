package players;

import angels.Angel;
import strategies.AttackStrategies.KnightAttackStrategy;
import strategies.Context;
import strategies.DefensiveStrategies.KnightDefensiveStrategy;
import players.PlayersConstants.KnightConstants;
import skills.SkillsVisitor;
import skills.KnightSkills;
import utils.Coordinates;
import observers.Observer;

/**
 * Class that implements the Knight player.
 * */
public final class Knight extends Hero {
    /**
     * Constructor.
     * @param c -> Coorinates - player's position.
     * It also initializes player's starting and max hp.
     * */
    public Knight(final Coordinates c) {
        super(c);
        this.setHp(KnightConstants.KNIGHT_STARTING_HP.getNumber());
        this.setMaxHp(KnightConstants.KNIGHT_STARTING_HP.getNumber());
    }

    /**
     * @return int -> Player's max hp after leveling up.
     * */
    @Override
    public int getMaxHpLevelUp() {
        return KnightConstants.KNIGHT_STARTING_HP.getNumber()
                + KnightConstants.KNIGHT_HP_PER_LEVEL.getNumber() * this.getLevel();
    }

    /**
     * Player chooses a strategy based on his hp.
     * */
    @Override
    public void pickStrategy() {
        final int three = 3;
        final int two = 2;
        if (getMaxHp() / three < getHp() && getHp() < getMaxHp() / two) {
            new Context(new KnightAttackStrategy()).executeStrategy(this);
        } else if (getHp() < getMaxHp() / three) {
            new Context(new KnightDefensiveStrategy()).executeStrategy(this);
        }
    }

    @Override
    public void addObserver(final Observer observer) {
        attach(observer);
    }

    @Override
    public void notifyObserver(final String str) {
        getObserver().update(str);
    }

    /**
     * @param skill -> Visit accept method.
     * */
    @Override
    public void accept(final SkillsVisitor skill) {
        skill.visit(this);
    }

    @Override
    public void acceptAngel(final Angel angel) {
        angel.angelVisit(this);
    }

    /**
     * @return SkillsVisitor -> Visitor.
     * */
    @Override
    public SkillsVisitor heroSkill() {
        return new KnightSkills(this);
    }
}
