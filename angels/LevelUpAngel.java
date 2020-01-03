package angels;

import angels.AngelsConstants.LevelUpAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the LevelUpAngel.
 * */
public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final Coordinates c) {
        super(c);
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, it changes player's modifiers accordingly.
     * In the end, it computes the XP that the curent player needs for leveling up.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.PYROMANCER_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, it changes player's modifiers accordingly.
     * In the end, it computes the XP that the curent player needs for leveling up.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.KNIGHT_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, it changes player's modifiers accordingly.
     * In the end, it computes the XP that the curent player needs for leveling up.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.ROGUE_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and notifies the GrandMagician.
     * After that, it changes player's modifiers accordingly.
     * In the end, it computes the XP that the curent player needs for leveling up.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            angelVisitUtilsHelped(hero);
            hero.setAngelModifier(LevelUpAngelConstants.WIZARD_MODIFIER.getNumber());
            hero.nextLevelXp();
        }
    }
}
