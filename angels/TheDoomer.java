package angels;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class TheDoomer extends Angel {
    public TheDoomer(final Coordinates c) {
        super(c);
    }

    private void angelVisitUtils(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(hero.getClass().getSimpleName())
                .append(" ").append(hero.getId()).append(" was killed by an angel");
        this.notifyAll(sb.toString());
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.kill();
            angelVisitUtilsHit(hero);
            angelVisitUtils(hero);
        }
    }
}
