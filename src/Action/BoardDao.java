package Action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;

import Beans.BoardBean;
import Beans.StudentBean;

import java.sql.*;

public class BoardDao extends CommonDao {
    public static BoardDao getInstance() {
        BoardDao _instance = new BoardDao();
        return _instance;
    }

    public ArrayList<BoardBean> getPostList(String dest, String lectureName) throws SQLException {
        //set query by dest, get result set
        String sql = "select POST.PNumber, Title, PERSON.PName as Writer, PDate, View_count, Contents "
                + "from POST, PERSON, COURSE, Student_take_course "
                + "where (Category_number=(select CNumber from post_category where CName=?) "
                + "and (Course_number=(SELECT CNumber FROM COURSE WHERE COURSE.CName=?) "
                + "OR (Course_number=null)))"
                + "and Course_number=(select CNumber from COURSE where CName=?) "
                + "and Author_number=PERSON.PNumber";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, dest);
        pstmt.setString(2, lectureName);
        pstmt.setString(3, lectureName);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<BoardBean> postList = new ArrayList<BoardBean>();
        while (rs.next()) {
            BoardBean post = new BoardBean();
            post.setIndex(rs.getInt("POST.PNumber"));
            post.setTitle(rs.getString("Title"));
            post.setWriter(rs.getString("PERSON.PName"));
            post.setDate(rs.getDate("PDate"));
            post.setView(rs.getInt("View_count"));
            post.setContent(rs.getString("Content"));
            postList.add(post);
        }
        closeConnection();
        return postList;
    }

    public ArrayList<StudentBean> getStudentList(String professorId, String lectureName) throws SQLException {
        //set query by professor id, lecture name, get result set
        String sql = "SELECT PName " +
                "FROM PERSON " +
                "WHERE PERSON.PNumber " +
                "IN (SELECT Student_number " +
                "    FROM Student_take_course " +
                "    WHERE Course_number = (SELECT CNumber FROM COURSE " +
                "        WHERE CName=? AND Professor_number=?));";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, lectureName);
        pstmt.setString(2, professorId);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<StudentBean> studentList = new ArrayList<StudentBean>();
        while (rs.next()) {
            StudentBean student = new StudentBean();
            student.setsNumber(rs.getString("SNumber"));
            student.setMajor_number(rs.getString("Major_number"));
            student.setsYear(rs.getInt("SYear"));
            student.setEmail(rs.getString("Email"));
            student.setsGender(rs.getString("SGender"));
            student.setPhone_number(rs.getString("Phone_number"));
        }

        return studentList;
    }

    public BoardBean getPost(String dest, String lectureName, String index) throws SQLException {
        //set query by dest, get result set
        String sql = "select POST.PNumber, Title, PERSON.PName as Writer, PDate, View_count, Contents, File_name "
                + "from POST, PERSON, COURSE "
                + "where POST.PNumber=? "
                + "and Category_number=(select CNumber from post_category where CName=?) "
                + "and (Course_number=(SELECT CNumber FROM COURSE WHERE COURSE.CName=?) "
                + "    OR (Course_number=null)) "
                + "and Author_number=PERSON.PNumber";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, index);
        pstmt.setString(2, dest);
        pstmt.setString(3, lectureName);
        ResultSet rs = pstmt.executeQuery();

        BoardBean post = new BoardBean();
        while (rs.next()) {
            post.setIndex(rs.getInt("POST.PNumber"));
            post.setTitle(rs.getString("Title"));
            post.setWriter(rs.getString("PERSON.PName"));
            post.setDate(rs.getDate("PDate"));
            post.setView(rs.getInt("View_count"));
            post.setContent(rs.getString("Content"));
            post.setFile(rs.getString("File_name"));
        }
        closeConnection();
        return post;
    }

    public void addPost(String dest, String lectureName, BoardBean post) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "select count(*) from board";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

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
        pstmt = openConnection().prepareStatement(sql);
        pstmt.executeUpdate();

        closeConnection();
    }

    public void deletePost(String index) throws SQLException {
        //set query by index
        String sql = "DELETE FROM POST WHERE PNumber=?";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, index);
        pstmt.executeUpdate();

        closeConnection();
    }

    public void updateView(BoardBean post) throws SQLException {
        String sql = "UPDATE TABLE POST SET View_count=? WHERE PNumber=?";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setInt(1, post.getView());
        pstmt.setInt(2, post.getIndex());
        pstmt.executeUpdate();

        closeConnection();
    }

    public ArrayList<String> getLectureList(String id) throws SQLException {
        //set query by id, get result set
        String sql = "SELECT COURSE.CName FROM COURSE " +
                "WHERE COURSE.CNumber " +
                "IN (SELECT Course_number " +
                "    FROM Student_take_course" +
                "    WHERE Student_number=?) " +
                "UNION " +
                "   SELECT COURSE.CName " +
                "   FROM COURSE " +
                "   WHERE Professor_number=?";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, id);
        ResultSet rs = pstmt.executeQuery();

        //declare lectureList
        ArrayList<String> lectureList = new ArrayList<String>();
        while (rs.next()) {
            lectureList.add(rs.getString("CName"));
        }

        return lectureList;
    }
}
