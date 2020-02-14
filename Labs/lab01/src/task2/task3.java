package task2;

public class task3 {
    public static void main(String [] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "Gigel";
        s2.name = "Gigel";
        s1.year = 2011;
        s2.year = 2011;

        /*
            Default returneaza false, dar o sa returneze true pentru ca am suprascris metoda equals.
        * */
        System.out.println(s1.equals(s2));
    }
}
