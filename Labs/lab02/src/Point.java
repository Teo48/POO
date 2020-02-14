public class Point {
    private float x, y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void print(Point p) {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
}
