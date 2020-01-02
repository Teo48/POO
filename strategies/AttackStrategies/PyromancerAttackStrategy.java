package Strategies.AttackStrategies;

import Strategies.Strategy;
import players.Hero;
import players.Pyromancer;

public class PyromancerAttackStrategy implements Strategy {
    @Override
    public void modifyAttributes(Hero hero) {
        hero.setHp(hero.getHp() - hero.getHp() / 4);
        ((Pyromancer)hero).setAngelModifier(0.7f);
    }
}
