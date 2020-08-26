package Entities;

import java.util.Objects;

public class Student {
    public String Name;
    public String username;

    public Student(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(Name, student.Name) &&
                Objects.equals(username, student.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, username);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Student(String name, String username) {
        Name = name;
        this.username = username;
    }
}
