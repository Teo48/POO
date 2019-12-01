package players;

import skills.AttackVisitor;
import skills.PyromancerSkills;
import utils.Coordinates;

public class Pyromancer extends Hero {
    public Pyromancer(Coordinates c) {
        super(c);
        this.setHp(500);
        this.setMaxHp(500);
    }

    @Override
    public int getMaxHp() {
        return 500 + 50 * this.getLevel();
    }

    @Override
    public void accept(AttackVisitor skill) {
        skill.visit(this);
    }

    @Override
    public AttackVisitor heroSkill() {
        return new PyromancerSkills(this);
    }
}
