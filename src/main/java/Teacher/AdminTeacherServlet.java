package Teacher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/adminsterteacher.do")
public class AdminTeacherServlet extends HttpServlet {
    AdminTeacherService x = new AdminTeacherService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    request.setAttribute("TeacherList",x.ShowTeachers());
        request.getRequestDispatcher("/WEB-INF/views/AdminTeacherView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        try {
            x.AddNewTeacher(request.getParameter("teachername"), Integer.parseInt(request.getParameter("telephone")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("TeacherList",x.ShowTeachers());
        request.getRequestDispatcher("/WEB-INF/views/AdminTeacherView.jsp").forward(request,response);
    }
}
