package Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminTeacherService {
    public List<Teacher> ShowTeachers(){
        List<Teacher> x = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT TeacherName from Teacher";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                x.add(new Teacher(rs.getString("TeacherName"))) ;
            }

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return x;
    }
}
