package Entities;

import java.util.Objects;

public class ViewCourse {
    public String coursename;
    public String grade;
    public String teachername;
    public int teachertelephone;


    public ViewCourse() {
    }


    @Override
    public String toString() {
        return "ViewCourse{" +
                "coursename='" + coursename + '\'' +
                ", grade='" + grade + '\'' +
                ", teachername='" + teachername + '\'' +
                ", teachertelephone=" + teachertelephone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewCourse that = (ViewCourse) o;
        return teachertelephone == that.teachertelephone &&
                Objects.equals(coursename, that.coursename) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(teachername, that.teachername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coursename, grade, teachername, teachertelephone);
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getTeachertelephone() {
        return teachertelephone;
    }

    public void setTeachertelephone(int teachertelephone) {
        this.teachertelephone = teachertelephone;
    }
}
