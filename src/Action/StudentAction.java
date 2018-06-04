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
        ArrayList<String> lectureList = null;
        String lectureName = null;

        HttpSession session = request.getSession();

        //get professor id, lecture name
        String professorId = session.getAttribute("id").toString();
        System.out.println("at StudentAction... professorId = " + professorId);

        //set or update lecture at session
        if (request.getParameterMap().containsKey("lectureName")) {
            lectureName = request.getParameter("lectureName");
            //get lecture list for select
            lectureList = BoardDao.getInstance().getLectureList(session.getAttribute("id").toString());
        }
        if (!request.getParameterMap().containsKey("lectureName")) {
            //get lecture list for select
            lectureList = BoardDao.getInstance().getLectureList(session.getAttribute("id").toString());
            //get 1st lecture name
            lectureName = lectureList.get(0);
        }
        System.out.println("at StudentAction... lectureName = " + lectureName);

        //get student list
        ArrayList<StudentBean> studentList = BoardDao.getInstance().getStudentList(professorId, lectureName);
        //set session attr
        session.setAttribute("lectureName", lectureName);
        //set request attr
        request.setAttribute("studentList", studentList);
        request.setAttribute("lectureList", lectureList);
        request.setAttribute("lectureName", lectureName);

        return "student.jsp";
    }
}
