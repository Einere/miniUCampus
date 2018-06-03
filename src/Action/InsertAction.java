package Action;

import Beans.BoardBean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        //get dest, lectureName
        String dest = request.getSession().getAttribute("dest").toString();
        String lectureName = request.getSession().getAttribute("lectureName").toString();

        //get file size, path
        MultipartRequest multi = null;
        int fileMaxSize = 10 * 1024 * 1024;
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println("if NullPointerException occurred, make "+filePath+"/upload directory");

        //save file
        try {
            multi = new MultipartRequest(request, filePath, fileMaxSize, "utf-8", new DefaultFileRenamePolicy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileName = multi.getFilesystemName("fileName");

        //set post bean
        BoardBean post = new BoardBean();
        post.setTitle(multi.getParameter("title"));
        post.setWriter(session.getAttribute("id").toString());
        post.setDate(Date.valueOf(multi.getParameter("date")));
        post.setView(0);
        post.setContent(multi.getParameter("content"));
        post.setFile(fileName);
        BoardDao.getInstance().addPost(dest, lectureName, post);

        return "insert.jsp";
    }
}
