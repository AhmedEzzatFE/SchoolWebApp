package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entities.Course;
import Entities.Student;

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

    public void AddNewCourse(String CourseName , int CreditHours, String TeacherName) throws SQLException {
        int TeacherID=0;
        Connection conn;
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");

        Statement stmt = conn.createStatement();
        String SQL = "SELECT TeacherID from Teacher where TeacherName='"+TeacherName+"'";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            TeacherID = rs.getInt("TeacherID");
        }

        String query = " insert into Course (CourseName,CreditHours,TeacherID)"
                + " values (?, ?, ?)";
        // create the mssql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, CourseName);
        preparedStmt.setInt(2, CreditHours);
        preparedStmt.setInt(3, TeacherID);
        // execute the preparedstatement
        preparedStmt.execute();

    }
        public static void main(String[] args) throws SQLException {
        AdminCourseService x = new AdminCourseService();
//        x.AddNewCourse("Math8",5,"Teacher1");
     System.out.println(x.ShowAllCourses());
    }
}
