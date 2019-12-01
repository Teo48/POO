package players;

import skills.SkillsVisitor;
import skills.WizardSkills;
import utils.Coordinates;

public class Wizard extends Hero {
    public Wizard(Coordinates c) {
        super(c);
        this.setHp(400);
        this.setMaxHp(400);
    }

    @Override
    public int getMaxHpLevelUp() {
        return 400 + this.getLevel() * 30;
    }

    @Override
    public void accept(SkillsVisitor skill) {
        skill.visit(this);
    }

    @Override
    public SkillsVisitor heroSkill() {
        return new WizardSkills(this);
    }
}
