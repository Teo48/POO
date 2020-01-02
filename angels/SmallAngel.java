package angels;

import angels.AngelsConstants.SmallAngelConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class SmallAngel extends Angel {
    public SmallAngel(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.PYROMANCER_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.PYROMANCER_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.KNIGHT_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.KNIGHT_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.ROGUE_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.ROGUE_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(SmallAngelConstants.WIZARD_MODIFIER.getNumber());
            hero.gainHp(SmallAngelConstants.WIZARD_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }
}
