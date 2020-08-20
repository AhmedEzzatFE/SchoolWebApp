package Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/studentship.do")
public class CourseServlet extends HttpServlet {
CourseService x = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",x.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.setAttribute("NewCourseList",x.ShowNewcourses((String) request.getSession().getAttribute("Username")));
        request.getRequestDispatcher("/WEB-INF/views/StudentCourses.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    System.out.println(request.getParameter("category"));
    try {
            x.AddCourse(request.getParameter("category"),(String) request.getSession().getAttribute("Username"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("CourseList",x.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.setAttribute("NewCourseList",x.ShowNewcourses((String) request.getSession().getAttribute("Username")));

        response.sendRedirect("/studentship.do");
//        request.getRequestDispatcher("/WEB-INF/views/StudentCourses.jsp").forward(request,response);
    }
}