package skills;

import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public interface SkillsVisitor {
    void visit(Pyromancer hero);

    void visit(Knight hero);

    void visit(Rogue hero);

    void visit(Wizard hero);
}
