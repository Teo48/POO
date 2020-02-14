package angels;

import angels.AngelsConstants.SmallAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the SmallAngel.
 * */

public final class SmallAngel extends Angel {
    public SmallAngel(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, it increases current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.PYROMANCER_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.PYROMANCER_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, it increases current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.KNIGHT_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.KNIGHT_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, it increases current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.ROGUE_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.ROGUE_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Wizzard.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, it increases current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.WIZARD_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.WIZARD_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }
}
