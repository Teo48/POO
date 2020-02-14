public class Polygon {
    private int n;
    public Point [] points;

    public Polygon(int n) {
        this.n = n;
        points = new Point[n];
    }

    public Polygon(float [] v, int n) {
        this(n);
        for (int i = 0 ; i < n ; ++i) {
            points[i] = new Point(v[i], v[i + 1]);
        }
    }
}
