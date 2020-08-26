package DAO;


import Service.AdminService;
import Service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/administerStudent.do")
public class AdminServlet extends HttpServlet {
    AdminService x = new AdminService();
    CourseService ShowStudentBased = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",ShowStudentBased.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.setAttribute("StudentList",x.ShowStudentsAvailable());
        request.getRequestDispatcher("/WEB-INF/views/AdminStudentView.jsp").forward(request,response);
    }

}
