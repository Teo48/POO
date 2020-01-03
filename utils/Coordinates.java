package utils;

/**
 * Class that implements a pair of coordinates.
 * The first element is referenced as 'x' for the X axis
 * and the second element as 'y' for the Y axis.
 * */
public final class Coordinates {
    private int x;
    private int y;

    /**
     * Constructor.
     * @param x
     * @param y
     * */
    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param obj
     * @return boolean -> Two coordinates are equals if both x and y are equals.
     * */
    @Override
    public boolean equals(final Object obj) {
        return (this.x == ((Coordinates) obj).getX()
                && this.y == ((Coordinates) obj).getY());
    }

    /**
     * @return String -> x + " " + y
     * */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.x).append(" ").append(this.y);
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
