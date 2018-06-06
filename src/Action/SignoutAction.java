package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignoutAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        //get session
        HttpSession session = request.getSession();
        //reset id, identity
        session.removeAttribute("id");
        session.removeAttribute("name");
        session.removeAttribute("identity");
        session.removeAttribute("dest");
        session.removeAttribute("lectureName");
        return "home.jsp";
    }
}
