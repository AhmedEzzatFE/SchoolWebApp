package LoginPackage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginService {
    public static List<UserLogin> UsersList=new ArrayList<UserLogin>();
    static {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            Statement stmt = conn.createStatement();
            String SQL = "SELECT Username,Password FROM Student";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                UsersList.add(new UserLogin(rs.getString("Username"),rs.getString("Password"),false));
            }
            SQL="SELECT Username,Password FROM Admin";
            rs=stmt.executeQuery(SQL);
            while (rs.next()){
                UsersList.add(new UserLogin(rs.getString("Username"),rs.getString("Password"),true));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
//    public static void main(String[] args) throws SQLException {
//        System.out.println(UsersList);
//        LoginService x = new LoginService();
//        System.out.println(x.AddUser("hezzat4","12345","Ahmed",55555,21));
//    }
   public int isValid(String Username,String Password){
         if(!UsersList.contains(new UserLogin(Username,Password,true)) && UsersList.contains(new UserLogin(Username,Password,false))){
             return 0;//if he is not an admin, then return zero
         }
         else if(UsersList.contains(new UserLogin(Username,Password,true)) && !UsersList.contains(new UserLogin(Username,Password,false))){
            return 1;//if he is an admin, then return 1
         }
         else{
         return -1;//if the login trial is not successful}

   }}
   //For the sign up of the users
    public int AddUser(String Username,String password,String Name , int Telephone , int Age) throws SQLException {
        int validation= isValid(Username,password);
        if(validation==-1){
            UsersList.add(new UserLogin(Username,password,false));
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JdbcSchoolSchema;integratedSecurity=true;");
            String query = " insert into Student (StudentName,Username,Telephone,Age,Password)"
                    + " values (?, ?, ?, ?, ?)";
            // create the mssql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, Name);
            preparedStmt.setString(2, Username);
            preparedStmt.setInt (3, Telephone);
            preparedStmt.setInt (4, Age);
            preparedStmt.setString (5, password);
            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("Signed Up");
            return 1;
        }
        else{return 0;}
    }
}

