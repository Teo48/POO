package players;

import skills.AttackVisitor;
import skills.RogueSkills;
import utils.Coordinates;

public class Rogue extends Hero {
    public Rogue(Coordinates c) {
        super(c);
        this.setHp(600);
        this.setMaxHp(600);
    }

    @Override
    public int getMaxHpLevelUp() {
        return 600 + this.getLevel() * 40;
    }

    @Override
    public void accept(AttackVisitor skill) {
        skill.visit(this);
    }

    @Override
    public AttackVisitor heroSkill() {
        RogueSkills rogueSkills = new RogueSkills(this);
        super.setBackstab(super.getBackstab() + 1);
        return rogueSkills;
    }
}
