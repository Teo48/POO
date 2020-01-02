package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Wizard;

public final class WizardDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.WIZARD_DEFENSE_HP.getX());
        ((Wizard) hero).setAngelModifier(StrategiesConstants.WIZARD_DEFENSE_MODIFIER.getNumber());
    }
}
