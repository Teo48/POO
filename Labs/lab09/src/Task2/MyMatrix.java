package Task2;

public class MyMatrix implements Sumabil {
    private int[][] m;

    MyMatrix(int [][] mat) {
        m = new int[4][4];
        m = mat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; ++i, sb.append("\n")) {
            for (int j = 0; j < 4; ++j) {
                sb.append(m[i][j] + " ");
            }
        }

        return sb.toString();
    }

    @Override
    public void addValue(Sumabil value) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                m[i][j] += ((MyMatrix)value).m[i][j];
            }
        }
    }
}
