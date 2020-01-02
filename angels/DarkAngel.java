package angels;

import angels.AngelsConstants.DarkAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class DarkAngel extends Angel {
    public DarkAngel(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.WIZARD_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }
}
