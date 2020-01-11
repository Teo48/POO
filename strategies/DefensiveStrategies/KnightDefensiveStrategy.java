package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class KnightDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.KNIGHT_DEFENSE_HP.getX());
        hero.setAngelModifier(StrategiesConstants.KNIGHT_DEFENSE_MODIFIER.getNumber());
    }
}
