package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class RogueDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.ROGUE_DEFENSE_HP.getX());
        hero.setAngelModifier(StrategiesConstants.ROGUE_DEFENSE_MODIFIER.getNumber());
    }
}
