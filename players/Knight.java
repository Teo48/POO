package players;

import skills.AttackVisitor;
import skills.KnightSkills;
import utils.Coordinates;

public class Knight extends Hero {
    public Knight(Coordinates c) {
        super(c);
        this.setHp(900);
        this.setMaxHp(900);
    }

    @Override
    public int getMaxHpLevelUp() {
        return 900 + 80 * this.getLevel();
    }

    @Override
    public void accept(AttackVisitor skill) {
        skill.visit(this);
    }

    @Override
    public AttackVisitor heroSkill() {
        return new KnightSkills(this);
    }
}
