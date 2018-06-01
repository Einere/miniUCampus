package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.Statement;

public class SigninAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get id, pw, etc
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String identity = request.getParameter("identity");
        //set identity
        request.setAttribute("identity", identity);
        /*//connect to DB
        CommonDao cd = new CommonDao();
        String sql = "";
        ResultSet rs = cd.openConnection().executeQuery(sql);
        rs.next();

        //check if or not member
        if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))){
            //if member, set session, go to home.jsp
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("identity", identity);
            cd.closeConnection();
            return "home.jsp";
        }
        else{
            //if not member, return to login.jsp
            cd.closeConnection();
            return "login.jsp";
        }*/

        return "home.jsp";
    }
}
