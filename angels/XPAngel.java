package angels;

import angels.AngelsConstants.XPAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class XPAngel extends Angel {
    public XPAngel(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.PYROMANCER_XP.getNumber());
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.KNIGHT_XP.getNumber());
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.ROGUE_XP.getNumber());
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.WIZARD_XP.getNumber());
        }
    }
}
