package Action;

import Beans.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DetailAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get dest, lectureName, index
        String dest = request.getSession().getAttribute("dest").toString();
        String lectureName = request.getSession().getAttribute("lectureName").toString();
        String index = request.getParameter("index");

        BoardBean post = BoardDao.getInstance().getPost(dest, lectureName, index);
        request.setAttribute("index", post.getIndex());
        request.setAttribute("title", post.getTitle());
        request.setAttribute("writer", post.getWriter());
        request.setAttribute("date", post.getDate());
        request.setAttribute("view", post.getView());
        request.setAttribute("content", post.getContent());
        request.setAttribute("fileName", post.getFile());

        return "detail.jsp";
    }
}
