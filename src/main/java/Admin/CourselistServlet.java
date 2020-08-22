package Admin;


import Student.CourseService;
import Student.ViewCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/courselist.do")
public class CourselistServlet extends HttpServlet {
    AdminCourseService x = new AdminCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",x.ShowCourseList(request.getParameter("coursename")));
        request.getRequestDispatcher("/WEB-INF/views/ShowStudentList.jsp").forward(request,response);
    }

}
