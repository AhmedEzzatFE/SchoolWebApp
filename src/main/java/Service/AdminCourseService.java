package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entities.Course;
import Entities.Student;

public class AdminCourseService {

    public List<String> GetCourseName(String CID){
        List<String> x = new ArrayList<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "Select CourseName,CreditHours from Course where CourseID='"+CID+"'";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(rs.getString("CourseName"));
                 x.add(String.valueOf(rs.getInt("CreditHours")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return x;
    }
    public List<Course> ShowAllCourses() {
        List<Course> x = new ArrayList<>();
        List<String> y;
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "Select count (SID) as NumberOfStudents,CID from enroll group by CID";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                y=GetCourseName(rs.getString("CID"));
                x.add(new Course(y.get(0),Integer.parseInt(y.get(1)),Integer.parseInt(rs.getString("NumberOfStudents"))));
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

//        public static void main(String[] args) throws SQLException {
//        AdminCourseService x = new AdminCourseService();
////        x.AddNewCourse("Math8",5,"Teacher1");
//     System.out.println(x.ShowAllCourses());
//    }
}
