package angels;

import angels.AngelsConstants.DraculaConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the Dracula angel.
 * */
public final class Dracula extends Angel {
    public Dracula(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * The GrandMagician is notified.
     * And then it substracts HP from the current player.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.PYROMANCER_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.PYROMANCER_HP.getX());
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * The GrandMagician is notified.
     * And then it substracts HP from the current player.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.KNIGHT_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.KNIGHT_HP.getX());
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * The GrandMagician is notified.
     * And then it substracts HP from the current player.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.ROGUE_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.ROGUE_HP.getX());
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * The GrandMagician is notified.
     * And then it substracts HP from the current player.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DraculaConstants.WIZARD_MODIFIER.getNumber());
            angelVisitUtilsHit(hero);
            hero.takeHp(DraculaConstants.WIZARD_HP.getX());
        }
    }
}
