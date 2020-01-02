package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Knight;

public final class KnightDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.KNIGHT_DEFENSE_HP.getX());
        ((Knight) hero).setAngelModifier(StrategiesConstants.KNIGHT_DEFENSE_MODIFIER.getNumber());
    }
}
