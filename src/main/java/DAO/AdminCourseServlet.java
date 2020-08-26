package DAO;


import Service.AdminCourseService;
import Service.AdminTeacherService;

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
    AdminTeacherService y = new AdminTeacherService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",x.ShowAllCourses());
        request.setAttribute("TeacherList",y.ShowTeachers());

        request.getRequestDispatcher("/WEB-INF/views/AdminCourseView.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        try {
            x.AddNewCourse(request.getParameter("coursename"), Integer.parseInt(request.getParameter("credithours")),request.getParameter("Teacher"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("TeacherList",y.ShowTeachers());
        request.setAttribute("CourseList",x.ShowAllCourses());
        request.getRequestDispatcher("/WEB-INF/views/AdminCourseView.jsp").forward(request,response);
    }

}
