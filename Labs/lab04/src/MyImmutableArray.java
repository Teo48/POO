import java.util.ArrayList;

public class MyImmutableArray {
    private final ArrayList<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> array) {
        immutableArray = (ArrayList) array.clone();
    }

    public void getArray() {
        System.out.println(immutableArray);
    }

    public static void main(String [] args) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0 ; i < 10 ; ++i) {
            array.add(i * i + 3);
        }

        MyImmutableArray m = new MyImmutableArray(array);
        m.getArray();

        ArrayList<Integer> array1 = new ArrayList<>();

        for (int i = 0 ; i < 10 ; ++i) {
            array1.add(i * i - 3);
        }

        MyImmutableArray m2 = new MyImmutableArray(array);
//            m.immutableArray = array1;

//        m.immutableArray = m2.immutableArray;
    }

}

