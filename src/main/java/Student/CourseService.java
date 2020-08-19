package Student;

import Student.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    public  List<Course> ShowCourses(String Username){
        System.out.println(Username);
        List<Course> CourseList=new ArrayList<Course>();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT CourseName,CreditHours from Course where CourseID" +
                    " in(SELECT CID FROM enroll where SID=(SELECT StudentID from Student where Username='"+Username+"'))";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                CourseList.add(new Course(rs.getString("CourseName"),rs.getInt("CreditHours")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }return CourseList;
    }

//        public static void main(String[] args) throws SQLException {
//        CourseService x = new CourseService();
//       x.ShowCourses("hezzat46");
//    }

}
