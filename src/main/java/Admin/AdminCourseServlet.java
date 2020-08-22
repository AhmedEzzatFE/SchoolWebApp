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

@WebServlet(urlPatterns = "/courseadmin.do")
public class AdminCourseServlet extends HttpServlet {
   AdminCourseService x = new AdminCourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",x.ShowAllCourses());
        request.getRequestDispatcher("/WEB-INF/views/AdminCourseView.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("TeacherList",x.ShowAllCourses());
        request.getRequestDispatcher("/WEB-INF/views/AdminCourseView.jsp").forward(request,response);
    }

}
