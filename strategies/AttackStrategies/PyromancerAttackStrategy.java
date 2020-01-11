package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class PyromancerAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.takeHp(hero.getHp() / StrategiesConstants.PYROMANCER_HP_ATTACK.getX());
        hero.setAngelModifier(StrategiesConstants
                .PYROMANCER_ATTACK_MODIFIER.getNumber());
    }
}
