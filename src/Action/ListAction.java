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

        //if para is null, set dest session
        try{
            if(!request.getParameter("dest").equals(null)) request.getSession().setAttribute("dest", request.getParameter("dest"));
        }
        catch(Exception e){

        }

        //check lecture or free
        String dest = request.getSession().getAttribute("dest").toString();
        ArrayList<BoardBean> postList = BoardDao.getInstance().getPostList(dest);
        request.setAttribute("postList", postList);

        return "board.jsp";
    }
}
