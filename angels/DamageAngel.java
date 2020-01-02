package angels;

import angels.AngelsConstants.DamageAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class DamageAngel extends Angel {
    public DamageAngel(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.PYROMANCER_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.KNIGHT_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.ROGUE_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(DamageAngelConstants.WIZARD_MODIFIER.getNumber());
            angelVisitUtilsHelped(hero);
        }
    }
}
