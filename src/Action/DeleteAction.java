package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import java.sql.*;

public class DeleteAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        String index = request.getParameter("index");
        BoardDao.getInstance().deletePost(index);

        return "delete.jsp";
    }
}
