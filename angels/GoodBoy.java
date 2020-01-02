package angels;

import angels.AngelsConstants.GoodBoyConstants;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;
import utils.Coordinates;

public final class GoodBoy extends Angel {
    public GoodBoy(final Coordinates c) {
        super(c);
    }

    @Override
    public void angelVisit(final Pyromancer hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(GoodBoyConstants.PYROMANCER_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.PYROMANCER_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Knight hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(GoodBoyConstants.KNIGHT_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.KNIGHT_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Rogue hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(GoodBoyConstants.ROGUE_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.ROGUE_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }

    @Override
    public void angelVisit(final Wizard hero) {
        if (!hero.isDead()) {
            hero.setAngelModifier(GoodBoyConstants.WIZARD_MODIFIER.getNumber());
            hero.gainHp(GoodBoyConstants.WIZARD_HP.getX());
            angelVisitUtilsHelped(hero);
        }
    }
}
