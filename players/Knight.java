package players;

import players.PlayersConstants.KnightConstants;
import skills.SkillsVisitor;
import skills.KnightSkills;
import utils.Coordinates;

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
        return new KnightSkills(this);
    }
}
