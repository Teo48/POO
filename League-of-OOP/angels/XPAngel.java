package angels;

import angels.AngelsConstants.XPAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the XPAngel.
 * */

public final class XPAngel extends Angel {
    public XPAngel(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, the current player receives XP accordingly.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.PYROMANCER_XP.getNumber());
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, the current player receives XP accordingly.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.KNIGHT_XP.getNumber());
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, the current player receives XP accordingly.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.ROGUE_XP.getNumber());
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, the current player receives XP accordingly.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.addXp(XPAngelConstants.WIZARD_XP.getNumber());
        }
    }
}
