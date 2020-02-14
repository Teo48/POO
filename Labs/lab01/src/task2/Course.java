package task2;

import java.util.*;

public class Course {
    String title;
    String Description;
    Student [] students;

    Student [] filterYear(Student [] students, int year) {
        Student [] result = new Student[1];
        int i = 0;
        for (Student s : students) {
            if (s.year == year) {
                result[i++] = s;
                result = Arrays.copyOf(result, result.length + 1);
            }
        }

        return result;
    }

}