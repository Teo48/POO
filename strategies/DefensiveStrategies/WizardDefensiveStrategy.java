package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class WizardDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.WIZARD_DEFENSE_HP.getX());
        hero.setAngelModifier(StrategiesConstants.WIZARD_DEFENSE_MODIFIER.getNumber());
    }
}
