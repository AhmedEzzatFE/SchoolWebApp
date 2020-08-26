package Service;

import Entities.Course;
import Entities.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminTeacherService {
    public List<Teacher> ShowTeachers(){
        List<Teacher> x = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT TeacherName,Telephone,Field from Teacher";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Teacher(rs.getString("TeacherName"),Integer.parseInt(rs.getString("Telephone")),rs.getString("Field"))) ;
            }

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }
    public List<Course>ShowCoursesAssigned(String TeacherName){
        List<Course> x = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "Select CourseName from Course where TeacherID in(SELECT TeacherID from Teacher where TeacherName='"+TeacherName+"')";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Course(rs.getString("CourseName")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }
    public void AddNewTeacher(String teachername, int telephone) throws SQLException {
try{
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    String query = " insert into Teacher (TeacherName,Telephone)"
        + " values (?, ?)";
    // create the mssql insert preparedstatement
    PreparedStatement preparedStmt = conn.prepareStatement(query);
    preparedStmt.setString(1, teachername);
    preparedStmt.setInt(2, telephone);
    // execute the preparedstatement
    preparedStmt.execute();
} catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    }
        public static void main(String[] args) throws SQLException {
        AdminTeacherService x = new AdminTeacherService();
        x.AddNewTeacher("Teacher30",332323);
    }
}
