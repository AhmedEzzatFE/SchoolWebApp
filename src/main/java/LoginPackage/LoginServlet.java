package LoginPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
        LoginService x = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String password= request.getParameter("password");
        String Username= request.getParameter("Username");
        int Validation = x.isValid(Username,password);
        System.out.println(Validation);
        if(Validation==-1){
                request.setAttribute("errorMessage","Invalid Credentials");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        }
        else if(Validation==1){
            request.getSession().setAttribute("name",Username);
            //if he is an admin then he should be redirected to the admin Page
            response.sendRedirect("/administer.do");
        }
        else if(Validation==0){
            //if he is a student then he should be redirected to the normal student Page
            request.getSession().setAttribute("Username",Username);
            response.sendRedirect("/studentship.do");
        } }
}