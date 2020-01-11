package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class KnightAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.takeHp(hero.getHp() / StrategiesConstants.KNIGHT_ATTACK_HP.getX());
        hero.setAngelModifier(StrategiesConstants
                .KNIGHT_ATTACK_MODIFIER.getNumber());
    }
}
