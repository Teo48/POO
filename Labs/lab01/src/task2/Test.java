package task2;

import java.util.*;

/*
 *  Argumentele pasate in linia de comanda sunt 2011 2024 2011 3000
    Pentru a seta argumente : Run -> Edit Configuration -> Program Arugments
 */

public class Test {
    public static void main(String [] args) {
        Course c = new Course();
        Student [] s = new Student[4];

        for (int i = 0 ; i < s.length ; ++i) {
            s[i] = new Student();
            s[i].name = "Gigelache" + Integer.toString((i + '0'));

            try {
                s[i].year = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        c.students = s;
        Student [] result;
        result = c.filterYear(s, 2011);

        /*
           For-ul pe colectii genereaza NullPointerException pentru ca eu in filterYear aloc un element in plus la
           fiecare egalitate. Asa ca avem doua variante: fie tratez exceptia, fie parcurg pana la result.length - 1
        */
//        for (Student st : result) {
//            try {
//                System.out.println(st.name + " " + st.year);
//            } catch (NullPointerException e) {
//            }
//        }

        System.out.println("=======================================================================");

        for (int i = 0 ; i < result.length - 1; ++i) {
            System.out.println(result[i].name + " e in anul " + result[i].year);
        }

        System.out.println("=======================================================================");
        // Alternativ cu ArrayList si asa scapam de exceptii ca isi face singur append in CourseArrayList.

//        CourseArrayList cList = new CourseArrayList();
//        cList.students = s;
//        ArrayList<Student> result = cList.filterYear(s, 2011);
//        for (Student st : result) {
//            System.out.println(st.name + " e in anul " + st.year);
//        }
    }
}
