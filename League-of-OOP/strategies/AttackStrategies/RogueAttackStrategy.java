package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class RogueAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.takeHp(hero.getHp() / StrategiesConstants.ROGUE_ATTACK_HP.getX());
        hero.setAngelModifier(StrategiesConstants.ROGUE_ATTACK_MODIFIER.getNumber());
    }
}
