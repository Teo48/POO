package angels;

import angels.AngelsConstants.SpawnerConstants;
import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class Spawner extends Angel {
    public Spawner(final Coordinates c) {
        super(c);
    }

    private void angelVisitUtils(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(hero.getClass().getSimpleName())
                .append(" ").append(hero.getId()).append(" was brought to life by an angel");
        this.notifyAll(sb.toString());
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.PYROMANCER_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.KNIGHT_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (hero.isDead()) {
            hero.revive();
            hero.setHp(SpawnerConstants.ROGUE_HP.getNumber());
            angelVisitUtilsHelped(hero);
            angelVisitUtils(hero);
        }
    }

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
