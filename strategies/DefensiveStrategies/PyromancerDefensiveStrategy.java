package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;

public final class PyromancerDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.PYROMANCER_HP_DEFENSE.getX());
        hero.setAngelModifier(StrategiesConstants
                .PYROMANCER_DEFENSE_MODIFIER.getNumber());
    }
}
