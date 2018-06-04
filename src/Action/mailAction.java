package Action;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.internet.*;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class mailAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        try {
            HttpSession session = request.getSession();

            final String host = "smtp.naver.com";
            final int port = 456;
            final String userName = "cutiemung2";
            final String password = "wjd1d1d1"; // 실제 네이버 비밀번호

            String[] recipients = {
                    request.getParameter("receiver") //ex) kjwsx23@naver.com
            };

            InternetAddress[] addrs = new InternetAddress[recipients.length];
            for (int index = 0; index < recipients.length; ++index) {
                addrs[index] = new InternetAddress(recipients[index]);
            }

            String subject = request.getParameter("subject");
            String body = request.getParameter("body");

            Properties props = System.getProperties();

            props.put("mail.smtp.user", "cutiemung2@naver.com");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session sess = Session.getInstance(props, new javax.mail.Authenticator() {
                String un = userName;
                String pw = password;

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(un, pw);
                }
            });
            Message mimeMessage = new MimeMessage(sess);
            mimeMessage.setFrom(new InternetAddress("cutiemung2@naver.com", session.getAttribute("name").toString()));
            mimeMessage.setRecipients(Message.RecipientType.TO, addrs);
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(body, "text/html;charset=utf-8");
            System.out.println("이메일 발송 중...");
            Transport.send(mimeMessage);

            System.out.println("정상적으로 메일이 발송되었습니다.");
        } catch (Exception e) {
            System.out.println("메일 발송에 실패하였습니다.");
        }

        return "student.jsp";
    }
}
