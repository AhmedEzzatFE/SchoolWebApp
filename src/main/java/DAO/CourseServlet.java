package DAO;

import Entities.ViewCourse;
import Service.CourseService;
import Service.ViewCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/studentship.do")
public class CourseServlet extends HttpServlet {
CourseService x = new CourseService();
ViewCourseService y = new ViewCourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setAttribute("CourseList",x.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.setAttribute("NewCourseList",x.ShowNewcourses((String) request.getSession().getAttribute("Username")));
        request.getRequestDispatcher("/WEB-INF/views/StudentCourses.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    String action = request.getParameter("action");
    System.out.println(action);
    System.out.println(request.getParameter("CourseList"));

    if(action == null){
        try {
            x.AddCourse(request.getParameter("CourseList"),(String) request.getSession().getAttribute("Username"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("CourseList",x.ShowCourses((String) request.getSession().getAttribute("Username")));
        request.setAttribute("NewCourseList",x.ShowNewcourses((String) request.getSession().getAttribute("Username")));
        response.sendRedirect("/studentship.do");
    }
    else{
        response.setContentType("html");
        String  Selected= request.getParameter("Selected");
        PrintWriter out = response.getWriter();
        ViewCourse SendingResponse = y.NewCourseDetails(Selected);
        out.println("Course Name:"+SendingResponse.coursename);

        out.println("Teacher Assigned to this course:"+SendingResponse.teachername);

        out.println("Teacher Contact Info: "+SendingResponse.teachertelephone);

    }
}

}