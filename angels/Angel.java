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

public abstract class Angel {
    private Coordinates coordinates;
    private List<Observer> observers = new LinkedList<>();

    public Angel() {
    }

    public Angel(final Coordinates c) {
        this.coordinates = c;
    }

    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final void angelVisitUtilsHelped(final Hero hero) {
        StringBuilder sb = new StringBuilder();
                sb.append(this.getClass().getSimpleName()).append(" helped ")
                .append(hero.getClass().getSimpleName() + " ").append(hero.getId());
        this.notifyAll(sb.toString());
    }

    public final void angelVisitUtilsHit(final Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" hit ")
                .append(hero.getClass().getSimpleName() + " ").append(hero.getId());
        this.notifyAll(sb.toString());
    }

    public final void addObserver(final Observer observer) {
        observers.add(observer);
    }

    public final void notifyAll(final String str) {
        for (Observer observer : observers) {
            observer.update(str);
        }
    }

    public abstract void angelVisit(Pyromancer hero);
    public abstract void angelVisit(Knight hero);
    public abstract void angelVisit(Rogue hero);
    public abstract void angelVisit(Wizard hero);

    /**
     * @return String
     * Format: Angel's name followed by his coordinates on map separated by ','"
     * */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ","
                + this.coordinates.getX() + "," + this.coordinates.getY();
    }
}
