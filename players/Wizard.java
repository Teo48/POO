package players;

import players.PlayersConstants.WizardConstants;
import skills.SkillsVisitor;
import skills.WizardSkills;
import utils.Coordinates;

/**
 * Class that implements the Wizard player.
 * */


public final class Wizard extends Hero {
    /**
     * Constructor.
     * @param c -> Coorinates - player's position.
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

    /**
     * @param skill -> Visit accept method.
     * */
    @Override
    public void accept(final SkillsVisitor skill) {
        skill.visit(this);
    }

    /**
     * @return SkillsVisitor -> Visitor.
     * */
    @Override
    public SkillsVisitor heroSkill() {
        return new WizardSkills(this);
    }
}
