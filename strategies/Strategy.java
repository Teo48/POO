package strategies;

import players.Hero;

@FunctionalInterface
public interface Strategy {
    void modifyAttributes(Hero hero);
}
