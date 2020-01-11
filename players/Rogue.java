package players;

import angels.Angel;
import strategies.HeroStrategyFactory;
import players.PlayersConstants.RogueConstants;
import skills.SkillsVisitor;
import skills.RogueSkills;
import utils.Coordinates;
import observers.Observer;

/**
 * Class that implements the Rogue player.
 * */


public final class Rogue extends Hero {
    /**
     * Constructor.
     * @param c -> Coorinates - player's position.
     * It also initializes player's starting and max hp.
     * */
    public Rogue(final Coordinates c) {
        super(c);
        this.setHp(RogueConstants.ROGUE_STARTING_HP.getNumber());
        this.setMaxHp(RogueConstants.ROGUE_STARTING_HP.getNumber());
    }

    /**
     * @return int -> Player's max hp after leveling up.
     * */
    @Override
    public int getMaxHpLevelUp() {
        return RogueConstants.ROGUE_STARTING_HP.getNumber()
                 +  RogueConstants.ROGUE_HP_PER_LEVEL.getNumber() * this.getLevel();
    }

    @Override
    public void pickStrategy() {
        final int seven = 7;
        final int five = 5;
        if (getMaxHp() / seven < getHp() && getHp() < getMaxHp() / five) {
            HeroStrategyFactory.getInstance("RogueAttackStrategy").modifyAttributes(this);
        } else if (getHp() < getMaxHp() / seven) {
            HeroStrategyFactory.getInstance("RogueDefensiveStrategy").modifyAttributes(this);
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
        RogueSkills rogueSkills = new RogueSkills(this);
        super.setBackstab(super.getBackstab() + 1);
        return rogueSkills;
    }
}
