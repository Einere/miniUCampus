package Action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;

import Beans.BoardBean;

import java.sql.*;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance() {
        BoardDao _instance = new BoardDao();
        return _instance;
    }

    public ArrayList<BoardBean> getPostList(String dest, String lectureName) throws SQLException {
        //set query, get result set
        String sql = "";
        //set query by dest
        if (dest.equals("lecture")) sql = "select * from board order by b_index desc";
        else if (dest.equals("free")) sql = "";
        ResultSet rs = openConnection().executeQuery(sql);
        ArrayList<BoardBean> postList = new ArrayList<BoardBean>();

        while (rs.next()) {
            BoardBean post = new BoardBean();
            post.setIndex(rs.getInt("b_index"));
            post.setTitle(rs.getString("b_title"));
            post.setWriter(rs.getString("b_writer"));
            post.setDate(rs.getDate("b_date"));
            post.setView(rs.getInt("b_view"));
            post.setContent(rs.getString("b_content"));
            postList.add(post);
        }
        closeConnection();
        return postList;
    }

    public BoardBean getPost(String index) throws SQLException {
        String sql = "select * from board where b_index = " + index;
        ResultSet rs = openConnection().executeQuery(sql);
        BoardBean post = new BoardBean();

        while (rs.next()) {
            post.setIndex(rs.getInt("b_index"));
            post.setTitle(rs.getString("b_title"));
            post.setWriter(rs.getString("b_writer"));
            post.setDate(rs.getDate("b_date"));
            post.setView(rs.getInt("b_view"));
            post.setContent(rs.getString("b_content"));
            post.setFile(rs.getString("b_file"));
            post.setIp(rs.getString("b_ip"));
        }
        closeConnection();
        return post;
    }

    public void addPost(BoardBean post) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "select count(*) from board";
        ResultSet rs = openConnection().executeQuery(sql);
        rs.next();
        int index = rs.getInt(1) + 1; //column name = count(*)..? anyway, recommend to use column index 1
        String title = post.getTitle();
        String writer = post.getWriter();
        Date date = post.getDate();
        int view = post.getView();
        String content = post.getContent();
        String ip = post.getIp();
        String fileName = post.getFile();

        sql = "INSERT INTO board (b_index, b_title, b_writer, b_date, b_view, b_content, b_file, b_ip)"
                + " VALUES (" + index + ", '" + title + "', '" + writer + "', '" + sdf.format(date) + "', " + view + ", '" + content + "', '" + fileName + "', '" + ip + "')";
        openConnection().executeUpdate(sql);

        closeConnection();
    }

    public void deletePost(String index) throws SQLException {
        String sql = "delete from board where b_index = " + index;
        openConnection().executeUpdate(sql);

        closeConnection();
    }

    public void updateView(BoardBean post) throws SQLException {
        String sql = "update board set b_view=" + post.getView() + " where b_index=" + post.getIndex();
        openConnection().executeUpdate(sql);

        closeConnection();
    }

    public ArrayList<String> getLectureList(String id) throws SQLException {
        String sql = "";
        ResultSet rs = openConnection().executeQuery(sql);

        //declare lectureList
        ArrayList<String> lectureList = new ArrayList<String>();
        while (rs.next()) {
            lectureList.add(rs.getString("lectureName"));
        }

        return lectureList;
    }
}
