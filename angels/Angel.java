package angels;

import players.Hero;
import players.Knight;
import players.Pyromancer;
import players.Wizard;
import players.Rogue;
import utils.Coordinates;
import utils.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class to define an angel.
 * This class will be extended.
 * */
public abstract class Angel {
    private Coordinates coordinates;
    private List<Observer> observers = new LinkedList<>();

    /**
     * Constructor.
     * @param c -> Angel's coordinates.
     * */
    public Angel(final Coordinates c) {
        this.coordinates = c;
    }

    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Utility method used by observer when an angel helps a player.
     * The notification message has the following format:
     * "Angel's name helped hero's name hero's ID.
     * @param hero
     * */
    public final void angelVisitUtilsHelped(final Hero hero) {
        StringBuilder sb = new StringBuilder();
                sb.append(this.getClass().getSimpleName()).append(" helped ")
                .append(hero.getClass().getSimpleName()).append(" ").append(hero.getId());
        this.notifyAll(sb.toString());
    }

    /**
     * Utility method used by observer when an angel hits a player.
     * The notification message has the following format:
     * "Angel's name hit hero's name hero's ID.
     * @param hero
     * */
    public final void angelVisitUtilsHit(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" hit ")
                .append(hero.getClass().getSimpleName() + " ").append(hero.getId());
        this.notifyAll(sb.toString());
    }

    /**
     * Adds an Observer to the observers' list.
     * @param observer
     * */
    public final void addObserver(final Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies all the observers.
     * @param str
     * */
    public final void notifyAll(final String str) {
        for (Observer observer : observers) {
            observer.update(str);
        }
    }

    /**
     * Visitor methods.
     * */
    public abstract void angelVisit(Pyromancer hero);
    public abstract void angelVisit(Knight hero);
    public abstract void angelVisit(Rogue hero);
    public abstract void angelVisit(Wizard hero);

    /**
     * @return String
     * Format: Angel's name followed by his coordinates on map separated by ','".
     * */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ","
                + this.coordinates.getX() + "," + this.coordinates.getY();
    }
}
