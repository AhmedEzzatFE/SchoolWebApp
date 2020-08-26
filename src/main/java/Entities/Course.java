package Entities;

import java.util.Objects;

public class Course {
    private String coursename;
    private int credithours;
    private int numberofstudents;
    private String currentgrade;


    @Override
    public String toString() {
        return "Course{" +
                "coursename='" + coursename + '\'' +
                ", credithours=" + credithours +
                ", numberofstudents=" + numberofstudents +
                ", currentgrade='" + currentgrade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credithours == course.credithours &&
                numberofstudents == course.numberofstudents &&
                Objects.equals(coursename, course.coursename) &&
                Objects.equals(currentgrade, course.currentgrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coursename, credithours, numberofstudents, currentgrade);
    }

    public String getCurrentgrade() {
        return currentgrade;
    }

    public void setCurrentgrade(String currentgrade) {
        this.currentgrade = currentgrade;
    }

    public Course(String coursename, int credithours,String currentgrade) {
        this.coursename = coursename;
        this.credithours = credithours;
        this.numberofstudents = numberofstudents;
        this.currentgrade = currentgrade;
    }

    public int getNumberofstudents() {
        return numberofstudents;
    }

    public void setNumberofstudents(int numberofstudents) {
        this.numberofstudents = numberofstudents;
    }

    public Course(String coursename, int credithours, int numberOfStudents) {
        this.coursename = coursename;
        this.credithours = credithours;
        numberofstudents = numberOfStudents;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredithours() {
        return credithours;
    }

    public void setCredithours(int credithours) {
        this.credithours = credithours;
    }

    public Course(String coursename) {
        this.coursename = coursename;
    }

    public Course(String coursename, int credithours) {
        this.coursename = coursename;
        this.credithours = credithours;
    }
}
