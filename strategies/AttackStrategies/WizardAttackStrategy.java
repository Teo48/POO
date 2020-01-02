package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Wizard;

public final class WizardAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategiesConstants.WIZARD_ATTACK_HP.getX());
        ((Wizard) hero).setAngelModifier(StrategiesConstants.WIZARD_ATTACK_MODIFIER.getNumber());
    }
}
