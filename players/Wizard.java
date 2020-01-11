package players;

import angels.Angel;
import strategies.HeroStrategyFactory;
import players.PlayersConstants.WizardConstants;
import skills.SkillsVisitor;
import skills.WizardSkills;
import utils.Coordinates;
import observers.Observer;

/**
 * Class that implements the Wizard player.
 * */
public final class Wizard extends Hero {
    /**
     * Constructor.
     * @param c -> Coordinates - player's position.
     * It also initializes player's starting and max hp.
     * */
    public Wizard(final Coordinates c) {
        super(c);
        this.setHp(WizardConstants.WIZARD_STARTING_HP.getNumber());
        this.setMaxHp(WizardConstants.WIZARD_STARTING_HP.getNumber());
    }

    /**
     * @return int -> Player's max hp after leveling up.
     * */
    @Override
    public int getMaxHpLevelUp() {
        return WizardConstants.WIZARD_STARTING_HP.getNumber()
                + WizardConstants.WIZARD_HP_PER_LEVEL.getNumber() * this.getLevel();
    }

    @Override
    public void pickStrategy() {
        final int two = 2;
        final int four = 4;
        if (getMaxHp() / four < getHp() && getHp() < getMaxHp() / two) {
            HeroStrategyFactory.getInstance("WizardAttackStrategy").modifyAttributes(this);
        } else if (getHp() < getMaxHp() / four) {
            HeroStrategyFactory.getInstance("WizardDefensiveStrategy").modifyAttributes(this);
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
        return new WizardSkills(this);
    }
}
