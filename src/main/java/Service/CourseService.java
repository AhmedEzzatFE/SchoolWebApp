package Service;

import Entities.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    public String GetGrade(String CourseName, String Username){
        String Grade= null;
        int CID =0;
        int SID=0;
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT CourseID from Course where CourseName='"+CourseName+"'";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
            CID = Integer.parseInt(rs.getString("CourseID"));
            }
            SQL="SELECT StudentID from Student where Username='"+Username+"'";
            rs= stmt.executeQuery(SQL);
            while (rs.next()) {
                SID = Integer.parseInt(rs.getString("StudentID"));
            }
            SQL="SELECT Grade from enroll where SID='"+SID+"' and CID='"+CID+"'";
            rs= stmt.executeQuery(SQL);
            while (rs.next()) {
                Grade= rs.getString("Grade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Grade;
    }
    public List<Course> ShowCourses(String Username) {
        List<Course> CourseList = new ArrayList<>();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT CourseName,CreditHours from Course where CourseID" +
                    " in(SELECT CID FROM enroll where SID=(SELECT StudentID from Student where Username='" + Username + "'))";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {

                CourseList.add(new Course(rs.getString("CourseName"), rs.getInt("CreditHours"),GetGrade(rs.getString("CourseName"),Username)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CourseList;
    }

    public void AddCourse(String Coursename, String Username) throws SQLException {
        int StudentID = 0;
        int CourseID = 0;

        try {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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

            String query = " insert into enroll (SID,CID)"
                    + " values (?, ?)";
            // create the mssql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, StudentID);
            preparedStmt.setInt(2, CourseID);
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Course> ShowNewcourses(String Username) {
        List<Course> x = new ArrayList<>();
        int StudentID = 0;
        try {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Statement stmt = conn.createStatement();
            String SQL = "SELECT StudentID from Student where Username='" + Username + "'";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                StudentID = rs.getInt("StudentID");
            }
            SQL = "Select CourseName From Course where CourseID NOT IN (SELECT CID from enroll where SID='" + StudentID + "')";
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Course(rs.getString("CourseName")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }
//    public static void main(String[] args) throws SQLException {
//        CourseService x = new CourseService();
//       System.out.println(x.ShowCourses("hezzat46"));
//    }
}
