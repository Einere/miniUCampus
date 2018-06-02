package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
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

        //connect to DB, execute query, get result set
        CommonDao cd = new CommonDao();
        String sql = "SELECT * FROM person WHERE PNumber=? and Password=? and Student_or_Professor=?";
        PreparedStatement pstmt = cd.openConnection().prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        pstmt.setString(3, identity);
        ResultSet rs = pstmt.executeQuery();


        if(rs.next()){
            //get information
            String PNumber = rs.getString("PNumber");
            String PName = rs.getString("PName");
            String Password = rs.getString("Password");
            String Student_or_Professor = rs.getString("Student_or_Professor");

            //check if or not member
            if (id.equals(PNumber) && pw.equals(Password) && identity.equals(Student_or_Professor)) {
                //if member, set session, go to home.jsp
                HttpSession session = request.getSession();
                session.setAttribute("id", PNumber);
                session.setAttribute("name", PName);
                session.setAttribute("identity", Student_or_Professor);
                request.setAttribute("id", id);
                request.setAttribute("name", PName);
                request.setAttribute("identity", identity);
                System.out.println("success");
                cd.closeConnection();
                return "home.jsp";
            } else {
                //if not member, return to login.jsp
                cd.closeConnection();
                return "login.jsp";
            }
        }
        return "login.jsp";
    }
}
