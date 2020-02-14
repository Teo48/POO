import java.util.*;
import java.lang.*;

public class Student implements Comparable<Student> {
    private long id;
    private String name;
    private String surname;
    private double averageGrade;

    public Student(long id, String name, String surname, double averageGrade) {
        this.id = id; 
        this.name = name;
        this.surname = surname;
        this.averageGrade = averageGrade;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student s1) {
        if (this.getAverageGrade() == s1.getAverageGrade()) {
            if (this.getName() == s1.getName()) {
                return this.getSurname().compareTo(s1.getSurname());
            }

            return this.getName().compareTo(s1.getName());
        }

        return (int)(s1.getAverageGrade() - this.getAverageGrade());
    }

    @Override
    public String toString() {
        return "ID: " + this.getId()  + " " + this.getName()
                + " " + this.getSurname() + " are media " + this.getAverageGrade();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        return this.getAverageGrade() == ((Student) obj).getAverageGrade();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime + Objects.hash(this.getName(), this.getSurname());
    }
}