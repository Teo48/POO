package angels;

import angels.AngelsConstants.GoodBoyConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the GoodBoy angel.
 * */

public final class GoodBoy extends Angel {
    public GoodBoy(final Coordinates c) {
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
            hero.setAngelModifier(GoodBoyConstants.PYROMANCER_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.PYROMANCER_HP.getX());
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
            hero.setAngelModifier(GoodBoyConstants.KNIGHT_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.KNIGHT_HP.getX());
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
            hero.setAngelModifier(GoodBoyConstants.ROGUE_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.ROGUE_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, it increases current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(GoodBoyConstants.WIZARD_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.WIZARD_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }
}
