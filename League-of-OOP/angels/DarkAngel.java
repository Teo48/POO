package angels;

import angels.AngelsConstants.DarkAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the DarkAngel.
 * */

public final class DarkAngel extends Angel {
    public DarkAngel(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and substracts player's HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and substracts player's HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and substracts player's HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and substracts player's HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.takeHp(DarkAngelConstants.WIZARD_HP.getNumber());
            angelVisitUtilsHit(hero);
        }
    }
}
