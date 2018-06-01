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

        HttpSession session = request.getSession();
        //set dest. for choice whether lecture for free
        try{
            //change dest
            if(!request.getParameter("dest").equals(null)) session.setAttribute("dest", request.getParameter("dest"));
        }
        catch(Exception e){
            //not change dest
        }

        //get lecture list for select
        ArrayList<String> lectureList = BoardDao.getInstance().getLectureList(session.getAttribute("id").toString());
        //get 1st lecture name
        String lectureName = lectureList.get(0);
        //get post list by dest, lecture name
        String dest = session.getAttribute("dest").toString();
        ArrayList<BoardBean> postList = BoardDao.getInstance().getPostList(dest, lectureName);
        //set request attr
        request.setAttribute("postList", postList);
        request.setAttribute("lectureList", lectureList);
        request.setAttribute("dest", dest);
        return "board.jsp";
    }
}
