package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class WizardAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.takeHp(hero.getHp() / StrategiesConstants.WIZARD_ATTACK_HP.getX());
        hero.setAngelModifier(StrategiesConstants.WIZARD_ATTACK_MODIFIER.getNumber());
    }
}
