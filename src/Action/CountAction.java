package Action;

import Beans.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get session, dest, lectureName, index, post, ip
        HttpSession session = request.getSession();
        String dest = session.getAttribute("dest").toString();
        String lectureName = session.getAttribute("lectureName").toString();
        String index = request.getParameter("index");
        BoardBean post = BoardDao.getInstance().getPost(dest, lectureName, index);
        String ip = request.getRemoteAddr();

        if(!ip.equals(post.getIp())){
            //update post
            int view = post.getView();
            post.setView(++view);
            BoardDao.getInstance().updateView(post);

            System.out.println(ip);
            System.out.println(post.getIp());
        }
        request.setAttribute("index", index);
        return "redirectToDetail.jsp";
    }
}
