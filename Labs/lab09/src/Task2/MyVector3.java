package Task2;

public class MyVector3 implements Sumabil {
    private int [] array;

    MyVector3(int x, int y, int z) {
        array = new int[3];
        array[0] = x;
        array[1] = y;
        array[2] = z;

    }

    @Override
    public void addValue(Sumabil value) {
        for (int i = 0 ; i < 3 ; ++i) {
            array[i] += ((MyVector3) value ).array[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; ++i) {
            sb.append(array[i] + " ");
        }

        return sb.toString();
    }
}
