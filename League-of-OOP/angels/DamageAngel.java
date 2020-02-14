package angels;

import angels.AngelsConstants.DamageAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the DamageAngel.
 * */
public final class DamageAngel extends Angel {
    public DamageAngel(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.PYROMANCER_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.KNIGHT_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.ROGUE_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and changes its modifiers accordingly.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.WIZARD_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }
}
