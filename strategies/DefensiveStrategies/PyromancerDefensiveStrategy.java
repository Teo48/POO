package strategies.DefensiveStrategies;

import strategies.StrategiesConstants;
import strategies.Strategy;
import players.Hero;
import players.Pyromancer;

public final class PyromancerDefensiveStrategy implements Strategy {
    @Override
    public void modifyAttributes(final Hero hero) {
        hero.gainHp(hero.getHp() / StrategiesConstants.PYROMANCER_HP_DEFENSE.getX());
        ((Pyromancer) hero).setAngelModifier(StrategiesConstants
                .PYROMANCER_DEFENSE_MODIFIER.getNumber());
    }
}
