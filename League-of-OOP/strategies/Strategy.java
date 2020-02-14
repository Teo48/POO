package strategies;

import players.Hero;

@FunctionalInterface
public interface Strategy {
    /**
     * Method that changes hero's attributes based on chosen strategy.
     * @param hero
     * */
    void modifyAttributes(Hero hero);
}
