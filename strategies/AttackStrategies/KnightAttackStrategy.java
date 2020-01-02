package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Knight;

public final class KnightAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategiesConstants.KNIGHT_ATTACK_HP.getX());
        ((Knight) hero).setAngelModifier(StrategiesConstants
                .KNIGHT_ATTACK_MODIFIER.getNumber());
    }
}
