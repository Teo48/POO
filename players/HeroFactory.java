package players;

import utils.Coordinates;

public abstract class HeroFactory {
    public static Hero getHeroes(final String name, final Coordinates c) {
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
                throw new IllegalArgumentException("Invalid player");
        }
    }
}
