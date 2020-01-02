package angels;

import angels.AngelsConstants.LifeGiverConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class LifeGiver extends Angel {
    public LifeGiver(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.WIZARD_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }
}
