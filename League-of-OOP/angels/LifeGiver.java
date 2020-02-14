package angels;

import angels.AngelsConstants.LifeGiverConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the LifeGiver angel.
 * */

public final class LifeGiver extends Angel {
    public LifeGiver(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and increase its HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and increase its HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and increase its HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and increase its HP accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.gainHp(LifeGiverConstants.WIZARD_HP.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }
}
