package players;

import angels.Angel;
import strategies.HeroStrategyFactory;
import players.PlayersConstants.PyromancerConstants;
import skills.SkillsVisitor;
import skills.PyromancerSkills;
import utils.Coordinates;
import observers.Observer;

/**
 * Class that implements the Pyromancer player.
 * */

public final class Pyromancer extends Hero {
    /**
     * Constructor.
     * @param c -> Coorinates - player's position.
     * It also initializes player's starting and max hp.
     * */
    public Pyromancer(final Coordinates c) {
        super(c);
        this.setHp(PyromancerConstants.PYROMANCER_STARTING_HP.getNumber());
        this.setMaxHp(PyromancerConstants.PYROMANCER_STARTING_HP.getNumber());
    }

    /**
     * @return int -> Player's max hp after leveling up.
     * */
    @Override
    public int getMaxHpLevelUp() {
        return PyromancerConstants.PYROMANCER_STARTING_HP.getNumber()
                + PyromancerConstants.PYROMANCER_HP_PER_LEVEL.getNumber() * this.getLevel();
    }

    @Override
    public void pickStrategy() {
        final int three = 3;
        final int four = 4;
        if (getMaxHp() / four < getHp() && getHp() < getMaxHp() / three) {
            HeroStrategyFactory.getInstance("PyromancerAttackStrategy").modifyAttributes(this);
        } else if (super.getHp() < super.getMaxHp() / four) {
            HeroStrategyFactory.getInstance("PyromancerDefensiveStrategy").modifyAttributes(this);
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
        return new PyromancerSkills(this);
    }
}
