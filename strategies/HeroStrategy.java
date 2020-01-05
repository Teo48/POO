package strategies;

import players.Hero;

/**
 * Class whose behavior varies as per its strategy.
 * */
public final class HeroStrategy {
    private Strategy strategy;

    public HeroStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(final Hero hero) {
        strategy.modifyAttributes(hero);
    }
}
