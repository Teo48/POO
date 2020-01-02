package strategies.AttackStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Rogue;

public final class RogueAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.setHp(hero.getHp() - hero.getHp() / StrategiesConstants.ROGUE_ATTACK_HP.getX());
        ((Rogue) hero).setAngelModifier(StrategiesConstants.ROGUE_ATTACK_MODIFIER.getNumber());
    }
}
