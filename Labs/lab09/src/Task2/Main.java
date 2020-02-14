package Task2;

import java.util.*;

public class Main {
    private static void addAll(Collection<? extends Sumabil> sumabil) {
        Iterator<? extends Sumabil> it = sumabil.iterator();

        try {
            Sumabil firstElem = it.next();

            while (it.hasNext()) {
                firstElem.addValue(it.next());
            }
        } catch (NoSuchElementException e) {
            System.out.println("The collection is empty!");
        }
    }

    public static void main(String [] args) {
        int [][] mat1 = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };

        int [][] mat2 = {
                {1, 2, 3, 5},
                {1, 2, 3, 5},
                {1, 2, 3, 5},
                {1, 2, 3, 5},
        };

        int [][] mat3 = {
                {2, 2, 3, 4},
                {2, 2, 3, 4},
                {2, 2, 3, 4},
                {2, 2, 3, 4},
        };

        MyMatrix m1 = new MyMatrix(mat1);
        MyMatrix m2 = new MyMatrix(mat2);
        MyMatrix m3 = new MyMatrix(mat3);

        ArrayList<Sumabil> arrayList = new ArrayList<>();
        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);

        addAll(arrayList);

        System.out.println(m1 + "--------------------------");

        MyVector3 v1 = new MyVector3(1, 2, 3);
        MyVector3 v2 = new MyVector3(4, 5, 0);
        MyVector3 v3 = new MyVector3(6, 1, 0);

        arrayList.clear();
        arrayList.add(v1);
        arrayList.add(v2);
        arrayList.add(v3);

        addAll(arrayList);
        System.out.println(v1 + "\n" + "--------------------------");

        arrayList.clear();
        addAll(arrayList);
    }

}
