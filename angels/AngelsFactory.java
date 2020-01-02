package angels;

import exceptions.InvalidAngelException;
import utils.Coordinates;

public abstract class AngelsFactory {
    public static Angel getAngels(final String name, final Coordinates c)
            throws InvalidAngelException {
        switch (name) {
            case "DamageAngel":
                return new DamageAngel(c);
            case "DarkAngel":
                return new DarkAngel(c);
            case "Dracula":
                return new Dracula(c);
            case "GoodBoy":
                return new GoodBoy(c);
            case "LevelUpAngel":
                return new LevelUpAngel(c);
            case "LifeGiver":
                return new LifeGiver(c);
            case "SmallAngel":
                return new SmallAngel(c);
            case "Spawner":
                return new Spawner(c);
            case "TheDoomer":
                return new TheDoomer(c);
            case "XPAngel":
                return new XPAngel(c);
            default:
                throw new InvalidAngelException("Invalid Angel");
        }
    }
}
