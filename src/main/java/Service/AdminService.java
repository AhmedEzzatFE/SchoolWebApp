package Service;

import Entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
    public List<Student> ShowStudentsAvailable() {
        List<Student> x = new ArrayList<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT StudentName,Username from Student";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Student(rs.getString("StudentName"), rs.getString("Username")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }

    public void AddGrade(String Coursename, String Grade, String Username) throws SQLException {
        Connection conn;
        int StudentID = 0;
        int CourseID = 0;
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");

        Statement stmt = conn.createStatement();
        String SQL = "SELECT StudentID from Student where Username='" + Username + "'";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            StudentID = rs.getInt("StudentID");
        }
        SQL = "SELECT CourseID from Course where CourseName='" + Coursename + "'";
        rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            CourseID = rs.getInt("CourseID");
        }
        String query= "update enroll set Grade=? where SID=? and CID=? ";
        // create the mssql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, Grade);
        preparedStmt.setInt(2, StudentID);
        preparedStmt.setInt(3, CourseID);
        // execute the preparedstatement
        preparedStmt.execute();
    }
}
