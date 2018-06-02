package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.StudentBean;

import java.util.ArrayList;

public class StudentAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get professor id, lecture name
        String professorId = request.getParameter("professorId");
        String lectureName = request.getParameter("lectureName");

        //get student list
        ArrayList<StudentBean> studentList = BoardDao.getInstance().getStudentList(professorId, lectureName);

        //set request attr
        request.setAttribute("studentList", studentList);
        return "student.jsp";
    }
}
