package Student;

import Student.Course;

import javax.swing.text.View;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewCourseService {

    public  ViewCourse CourseDetails(String CourseName, String Username){
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

//        public static void main(String[] args) throws SQLException {
//        ViewCourseService x = new ViewCourseService();
//       x.CourseDetails("Math1","hezzat46");
//    }

}
