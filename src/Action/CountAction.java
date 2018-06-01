package Action;

import Beans.BoardBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        //get index, post, ip
        request.setCharacterEncoding("utf-8");
        String index = request.getParameter("index");
        BoardBean post = BoardDao.getInstance().getPost(index);
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
