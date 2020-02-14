package Task1;

import java.util.Objects;

public class MyObject {
    public String nume;
    public int varsta;

    public MyObject(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        return this.varsta == ((MyObject) obj).varsta;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + Objects.hash(this.nume, this.varsta);
    }

    public static void main(String [] args) {
        MyHashMap<MyObject, Integer> myHashMap = new MyHashMap<>(5);
        MyObject gigel = new MyObject("Gigel", 20);
        MyObject ionel = new MyObject("Ionel", 20);
        MyObject pgp = new MyObject("PGP", 31);
        myHashMap.put(gigel, 5);
        myHashMap.put(ionel, 30);
        myHashMap.put(pgp, 524);

        System.out.println(myHashMap.get(gigel));
        System.out.println(myHashMap.get(ionel));
        System.out.println(myHashMap.get(pgp));
    }

}
