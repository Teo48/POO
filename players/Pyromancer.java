package players;

import players.PlayersConstants.PyromancerConstants;
import skills.SkillsVisitor;
import skills.PyromancerSkills;
import utils.Coordinates;

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
    public int getMaxHp() {
        return PyromancerConstants.PYROMANCER_STARTING_HP.getNumber()
                + PyromancerConstants.PYROMANCER_HP_PER_LEVEL.getNumber() * this.getLevel();
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
        return new PyromancerSkills(this);
    }
}
