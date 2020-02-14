package angels;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

/**
 * Class that implements TheDoomer angel.
 * */

public final class TheDoomer extends Angel {
    public TheDoomer(final Coordinates c) {
        super(c);
    }

    /**
     * Utility method used by observer when the spawner brings a player back to life.
     * @param hero
     * */
    private void angelVisitUtils(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(hero.getClass().getSimpleName())
                .append(" ").append(hero.getId()).append(" was killed by an angel");
        this.notifyObserver(sb.toString());
    }

    /**
     * Visit method for a Pyromancer.
     * It checks if the player is not dead and kills it.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Knight.
     * It checks if the player is not dead and kills it.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Rogue.
     * It checks if the player is not dead and kills it.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    /**
     * Visit method for a Wizard.
     * It checks if the player is not dead and kills it.
     * After that, the GrandMagician is notified.
     * @param hero
     * */
    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }
}
