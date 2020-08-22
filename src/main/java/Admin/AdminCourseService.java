package Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Student.Course;
public class AdminCourseService {

    public List<Course> ShowAllCourses() {
        List<Course> x = new ArrayList<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT CourseName,CreditHours from Course";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Course(rs.getString("CourseName"), rs.getInt("CreditHours")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }

    public List<Student> ShowCourseList(String CourseName){
        List<Student> x = new ArrayList<>();
        int CourseID=0;
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
           String SQL = "SELECT CourseID from Course where CourseName='"+CourseName+"'";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                CourseID = rs.getInt("CourseID");
            }
            SQL = "SELECT StudentName from Student where StudentID in (SELECT SID from enroll where CID='"+CourseID+"');";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Student(rs.getString("StudentName")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }



        public static void main(String[] args) throws SQLException {
        AdminCourseService x = new AdminCourseService();
        x.ShowCourseList("Math1");
    }
}
