package Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/studentship.do")
public class CourseServlet extends HttpServlet {
CourseService x = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        ;
        request.setAttribute("CourseList",x.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.getRequestDispatcher("/WEB-INF/views/StudentCourses.jsp").forward(request,response);
    }
}