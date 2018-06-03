package Action;

import Beans.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get id, dest, lectureName, index, post, ip
        HttpSession session = request.getSession();
        String name = session.getAttribute("name").toString();
        String dest = session.getAttribute("dest").toString();
        String lectureName = session.getAttribute("lectureName").toString();
        String index = request.getParameter("index");
        BoardBean post = BoardDao.getInstance().getPost(dest, lectureName, index);
        System.out.println("in CountAction.. post.getWriter() = " + post.getWriter());
        if(!name.equals(post.getWriter())){
            //update post
            int view = post.getView();
            post.setView(++view);
            BoardDao.getInstance().updateView(post);
        }
        request.setAttribute("index", index);
        return "redirectToDetail.jsp";
    }
}
