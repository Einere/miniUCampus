package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

import Beans.BoardBean;
import Action.CommandAction;
import Action.BoardDao;

public class ListAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        ArrayList<String> lectureList = null;
        String lectureName = null;

        HttpSession session = request.getSession();
        //set dest. for choice whether lecture for free
        try {
            //set dest
            if (request.getParameterMap().containsKey("dest")) {
                session.setAttribute("dest", request.getParameter("dest"));
            }
            if (session.getAttribute("dest").equals("lecture")) {
                //get lecture list for select
                lectureList = BoardDao.getInstance().getLectureList(session.getAttribute("id").toString());
                //get 1st lecture name
                if (request.getParameterMap().containsKey("lectureName")) lectureName = request.getParameter("lectureName");
                else if(session.getAttribute("lectureName") != null) lectureName = session.getAttribute("lectureName").toString();
                else lectureName = lectureList.get(0);

                System.out.println("at ListAction... lecture name = " + lectureName);
                session.setAttribute("lectureName", lectureName);
            }
        } catch (Exception e) {
            //not change dest
            e.printStackTrace();
        }

        //get post list by dest, lecture name
        String dest = session.getAttribute("dest").toString();
        ArrayList<BoardBean> postList = BoardDao.getInstance().getPostList(dest, lectureName);
        //set request attr
        request.setAttribute("dest", dest);
        request.setAttribute("postList", postList);
        request.setAttribute("lectureList", lectureList);
        request.setAttribute("lectureName", lectureName);

        return "board.jsp";
    }
}
