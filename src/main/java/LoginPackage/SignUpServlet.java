package LoginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/signup.do")
public class SignUpServlet extends HttpServlet {
    LoginService x = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String password= request.getParameter("password");
        String Username= request.getParameter("Username");
        String Name= request.getParameter("Name");
        int Telephone= Integer.parseInt(request.getParameter("Telephone"));
        int Age= Integer.parseInt(request.getParameter("Age"));

        int isSignedUp= 0;
        try {
            isSignedUp = x.AddUser(Username,password,Name,Telephone,Age);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(isSignedUp==1){   request.setAttribute("errorMessage","You are Successfully signed up");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);}
        else{
            request.setAttribute("errorMessage","Invalid Sign Up");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request,response);
        }
}
}