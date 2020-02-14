package task2;

public class Student {
    String name;
    int year;

    Student() {
    }

    /*
        Suprascriem metoda equals pentru ca nu stim ce inseamna ca doi studenti sunt "egali".
        Am presupus ca doi studenti sunt egali daca se afla in acelasi an.
    * */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return true;
        }

        return this.year == ((Student) obj).year;
    }
}


