package Student;

import java.util.Objects;

public class Course {
    private String CourseName;
    private int CreditHours;

    @Override
    public String toString() {
        return "Course{" +
                "CourseName='" + CourseName + '\'' +
                ", CreditHours=" + CreditHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return CreditHours == course.CreditHours &&
                Objects.equals(CourseName, course.CourseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CourseName, CreditHours);
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int creditHours) {
        CreditHours = creditHours;
    }

    public Course(String courseName, int creditHours) {
        CourseName = courseName;
        CreditHours = creditHours;
    }
}
