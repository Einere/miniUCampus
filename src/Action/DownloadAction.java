package Action;

import Beans.BoardBean;
import Action.BoardDao;
import com.oreilly.servlet.multipart.ExceededSizeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.net.URLEncoder;

public class DownloadAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");

        //get file object
        HttpSession session = request.getSession();
        String dest = session.getAttribute("dest").toString();
        String lectureName = session.getAttribute("lectureName").toString();
        String index = request.getParameter("index");
        BoardBean post = BoardDao.getInstance().getPost(dest, lectureName, index);
        String fileName = post.getFile();
        String filePath = request.getSession().getServletContext().getRealPath("/upload") + "/" + fileName;
        File file = new File(filePath);

        //download
        if (file.exists() && file.isFile()) {
            try {
                //set size & type
                long fileSize = file.length();
                response.setContentType("application/x-msdownload");
                response.setContentLengthLong(fileSize);

                String client = request.getHeader("user-agent");
                if (client.indexOf("MSIE 5.5") != -1) {
                    response.setHeader("Content-Disposition", "filename=" + fileName + ";");
                } else {
                    //encoding, prevent '+' character fracture
                    fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
                    response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
                }

                //set header
                response.setHeader("Content-Length", String.valueOf(fileSize));
                response.setHeader("Content-Transfer-Encoding", "binary;");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "private");

                //open buffer, stream
                byte b[] = new byte[1024];
                BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

                //read & write
                int read = 0;
                while ((read = inStream.read(b)) != -1) {
                    outStream.write(b, 0, read);
                }

                //flush & close
                outStream.flush();
                outStream.close();
                inStream.close();
                System.out.println("Download complete");
            } catch (Exception e) {
                System.out.println("Download Exception : " + e.getMessage());
            }
        } else {
            System.out.println("Download Error : downFile Error [" + file + "]");
        }

        return null;
    }
}
