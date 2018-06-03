package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class redirectToHomeAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        //get session
        HttpSession session = request.getSession();
        //get & set id, name, identity
        request.setAttribute("id", session.getAttribute("id"));
        request.setAttribute("name", session.getAttribute("name"));
        request.setAttribute("identity", session.getAttribute("identity"));

        return "home.jsp";
    }
}
