package angels;

import angels.AngelsConstants.SpawnerConstants;
import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements the Spawner angel.
 * */

public final class Spawner extends Angel {
    public Spawner(final Coordinates c) {
        super(c);
    }

    /**
     * Utility method used by observer when the spawner brings a player back to life.
     * @param hero
     * */
    private void angelVisitUtils(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(hero.getClass().getSimpleName())
                .append(" ").append(hero.getId()).append(" was brought to life by an angel");
        this.notifyAll(sb.toString());
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is dead and revives it.
     * After that, it sets current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is dead and revives it.
     * After that, it sets current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is dead and revives it.
     * After that, it sets current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is dead and revives it.
     * After that, it sets current player's hp.
     * In the end, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.WIZARD_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }
}
