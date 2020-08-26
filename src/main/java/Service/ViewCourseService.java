package Service;

import Entities.ViewCourse;

import java.sql.*;

public class ViewCourseService {

    public ViewCourse CourseDetails(String CourseName, String Username){
        ViewCourse x = new ViewCourse();
        x.setCoursename(CourseName);
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL ="SELECT Grade FROM enroll where CID=(SELECT CourseID from Course where CourseName='"+CourseName+"') and " +
                    "SID=(SELECT StudentID from Student where Username='"+Username+"')";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.setGrade(rs.getString("Grade"));
            }
            SQL="SELECT TeacherName,Telephone from Teacher where" +
                    " TeacherID=(SELECT Course.TeacherID from Course where CourseName='"+CourseName+"')";
            rs=stmt.executeQuery(SQL);
            while(rs.next()){
                x.setTeachername(rs.getString("TeacherName"));
                x.setTeachertelephone(rs.getInt("Telephone"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public ViewCourse NewCourseDetails(String CourseName){
        ViewCourse x = new ViewCourse();
        x.setCoursename(CourseName);
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = SQL="SELECT TeacherName,Telephone from Teacher where" +
                    " TeacherID=(SELECT Course.TeacherID from Course where CourseName='"+CourseName+"')";
            ResultSet  rs=stmt.executeQuery(SQL);
            while (rs.next()) {
                x.setTeachername(rs.getString("TeacherName"));
                x.setTeachertelephone(rs.getInt("Telephone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }



}
