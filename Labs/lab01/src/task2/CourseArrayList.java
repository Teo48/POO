package task2;

import java.util.*;

public class CourseArrayList {
    String title;
    String Description;
    Student [] students;

    ArrayList<Student> filterYear(Student [] students, int year) {
        ArrayList<Student> result = new ArrayList<Student>();
        for (Student s : students) {
            if (s.year == year) {
                result.add(s);
            }
        }

        return result;
    }

}
