package angels;

import angels.AngelsConstants.LevelUpAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.PYROMANCER_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.KNIGHT_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.ROGUE_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.WIZARD_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }
}
