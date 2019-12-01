package players;

import exceptions.InvalidPlayerException;
import utils.Coordinates;

/**
 * Class that implements a factory for players.
 * */

public abstract class HeroFactory {
    public static Hero getHeroes(final String name, final Coordinates c)
            throws InvalidPlayerException {
        switch (name) {
            case "P":
                return new Pyromancer(c);
            case "K":
                return new Knight(c);
            case "R":
                return new Rogue(c);
            case "W":
                return new Wizard(c);
            default:
                throw new InvalidPlayerException("Invalid hero!");
        }
    }
}
