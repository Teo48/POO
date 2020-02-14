public class Task3 {
    public static void main(String [] args) {
        float [] v = new float[6];

        for (int i = 0 ; i < 6 ; ++i) {
            v[i] = (float)Math.PI + i;
        }

        Polygon p = new Polygon(v, 3);
        for (int i = 0 ; i < p.points.length ; ++i) {
            System.out.print("Punctul "  + i + ": "); p.points[i].print(p.points[i]);
        }
    }
}