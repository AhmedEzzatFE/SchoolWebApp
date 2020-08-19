package Student;

import java.util.Objects;

public class Course {
    private String coursename;
    private int credithours;

    @Override
    public String toString() {
        return "Course{" +
                "CourseName='" + coursename + '\'' +
                ", CreditHours=" + credithours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credithours == course.credithours &&
                Objects.equals(coursename, course.coursename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coursename, credithours);
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

    public Course(String coursename, int credithours) {
        this.coursename = coursename;
        this.credithours = credithours;
    }
}
