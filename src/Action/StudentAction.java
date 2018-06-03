package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.StudentBean;

import java.util.ArrayList;

public class StudentAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        //get professor id, lecture name
        String professorId = session.getAttribute("id").toString();

        //need to get lectureList... ListAction이랑 비슷하게 하면 될듯?
        //get lecture list for select
        ArrayList<String> lectureList = BoardDao.getInstance().getLectureList(session.getAttribute("id").toString());
        //get 1st lecture name
        String lectureName = lectureList.get(0);

        System.out.println("at StudentAction... lecture name = " + lectureName);
        session.setAttribute("lectureName", lectureName);

        //get student list
        ArrayList<StudentBean> studentList = BoardDao.getInstance().getStudentList(professorId, lectureName);

        //set request attr
        request.setAttribute("studentList", studentList);
        return "student.jsp";
    }
}
