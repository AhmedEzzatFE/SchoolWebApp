package Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/viewcourse.do")
public class ViewCourseServlet extends HttpServlet {
    ViewCourseService x = new ViewCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       System.out.println(request.getParameter("coursename"));
       request.setAttribute("Coursedetails",x.CourseDetails(request.getParameter("coursename"),(String) request.getSession().getAttribute("Username")));
        request.getRequestDispatcher("/WEB-INF/views/viewcourse.jsp").forward(request,response);
    }
}