package angels;

import angels.AngelsConstants.DraculaConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class Dracula extends Angel {
    public Dracula(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.PYROMANCER_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.PYROMANCER_HP.getX());
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.KNIGHT_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.KNIGHT_HP.getX());
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.ROGUE_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.ROGUE_HP.getX());
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.WIZARD_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.WIZARD_HP.getX());
        }
    }
}
