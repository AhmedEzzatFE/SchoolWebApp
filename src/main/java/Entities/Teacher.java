package Entities;

import java.util.Objects;

public class Teacher {
    public String Teachername;
    public int Telephone;

    public Teacher(String teachername, int telephone) {
        Teachername = teachername;
        Telephone = telephone;
    }

    public Teacher(String teachername) {
        Teachername = teachername;
    }

    public String getTeachername() {
        return Teachername;
    }

    public void setTeachername(String teachername) {
        Teachername = teachername;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int telephone) {
        Telephone = telephone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Teachername='" + Teachername + '\'' +
                ", Telephone=" + Telephone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Telephone == teacher.Telephone &&
                Objects.equals(Teachername, teacher.Teachername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Teachername, Telephone);
    }
}
