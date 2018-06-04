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
        String sql = "SELECT DISTINCT POST.PNumber, Category_number, Title, PERSON.PName AS Writer, PDate, View_count, Contents, File_name " +
                "FROM POST, PERSON, COURSE, Student_take_course " +
                "WHERE Category_number = ( " +
                "    SELECT CNumber FROM post_category " +
                "    WHERE CName = ? " +
                "        AND (Course_number = (SELECT CNumber FROM COURSE WHERE COURSE.CName = ?) " +
                "        OR (Course_number IS NULL))) " +
                "    AND POST.Author_number = PERSON.PNumber " +
                "ORDER BY POST.PNumber DESC";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, dest);
        pstmt.setString(2, lectureName);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<BoardBean> postList = new ArrayList<BoardBean>();
        while (rs.next()) {
            BoardBean post = new BoardBean();
            post.setIndex(rs.getInt("POST.PNumber"));
            post.setCategory_number(rs.getInt("Category_number"));
            post.setTitle(rs.getString("Title"));
            post.setWriter(rs.getString("Writer"));
            post.setDate(rs.getDate("PDate"));
            post.setView(rs.getInt("View_count"));
            post.setContent(rs.getString("Contents"));
            post.setFile(rs.getString("File_name"));
            postList.add(post);
        }

        closeConnection();
        return postList;
    }

    public ArrayList<StudentBean> getStudentList(String professorId, String lectureName) throws SQLException {
        //set query by professor id, lecture name, get result set
        String sql = "SELECT * FROM STUDENT " +
                "WHERE STUDENT.SNumber IN (SELECT Student_number " +
                "    FROM Student_take_course " +
                "    WHERE Course_number = (SELECT CNumber FROM COURSE " +
                "        WHERE CName=? AND Professor_number=?))";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, lectureName);
        pstmt.setString(2, professorId);
        ResultSet rs = pstmt.executeQuery();

        //set studentList
        ArrayList<StudentBean> studentList = new ArrayList<StudentBean>();
        while (rs.next()) {
            StudentBean student = new StudentBean();
            student.setSNumber(rs.getString("SNumber"));
            student.setMajor_number(rs.getString("Major_number"));
            student.setSYear(rs.getInt("SYear"));
            student.setEmail(rs.getString("Email"));
            student.setSGender(rs.getString("SGender"));
            student.setPhone_number(rs.getString("Phone_number"));
            studentList.add(student);
        }

        closeConnection();
        return studentList;
    }

    public BoardBean getPost(String dest, String lectureName, String index) throws SQLException {
        //set query by dest, get result set
        String sql = "SELECT POST.PNumber, Category_number, Title, PERSON.PName AS Writer, PDate, View_count, Contents, File_name " +
                "FROM POST, PERSON, COURSE " +
                "WHERE POST.PNumber = ? " +
                "AND (Category_number = ( " +
                "    SELECT CNumber FROM post_category WHERE CName = ?" +
                "    AND " +
                "    (Course_number = (SELECT CNumber FROM COURSE WHERE COURSE.CName = ?) " +
                "    OR (Course_number IS NULL)))) " +
                "    AND POST.PNumber = ? " +
                "AND Author_number = PERSON.PNumber";

        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, index);
        pstmt.setString(2, dest);
        pstmt.setString(3, lectureName);
        pstmt.setString(4, index);
        ResultSet rs = pstmt.executeQuery();

        BoardBean post = new BoardBean();
        while (rs.next()) {
            post.setIndex(rs.getInt("POST.PNumber"));
            post.setCategory_number(rs.getInt("Category_number"));
            post.setTitle(rs.getString("Title"));
            post.setWriter(rs.getString("Writer"));
            post.setDate(rs.getDate("PDate"));
            post.setView(rs.getInt("View_count"));
            post.setContent(rs.getString("Contents"));
            post.setFile(rs.getString("File_name"));
        }

        closeConnection();
        return post;
    }

    public void addPost(String dest, String lectureName, BoardBean post) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("in BoardDao.. dest = " + dest);
        System.out.println("in BoardDao.. lectureName = " + lectureName);
        //get index
        String sql = "select PNumber from post order by PNumber desc ";
        PreparedStatement pstmt = openConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int index = rs.getInt(1) + 1; //column name = count(*)..? anyway, recommend to use column index 1
        System.out.println("in BoardDao.. index = " + index);
        //get category_number
        sql = "select CNumber from post_category " +
                "where CName = ? " +
                "    AND (Course_number = (SELECT CNumber FROM COURSE WHERE COURSE.CName = ?) " +
                "        OR (Course_number is NULL));";
        pstmt = openConnection().prepareStatement(sql);
        pstmt.setString(1, dest);
        pstmt.setString(2, lectureName);
        rs = pstmt.executeQuery();
        rs.next();
        int category_number = rs.getInt(1);
        System.out.println("in BoardDao.. category_number = " + category_number);
        String title = post.getTitle();
        String writer = post.getWriter();
        Date date = post.getDate();
        int view = post.getView();
        String content = post.getContent();
        String fileName = post.getFile();

        sql = "INSERT INTO post (PNumber, Category_number, Author_number, Title, Contents, File_name, PDate, View_count) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        pstmt = openConnection().prepareStatement(sql);
        pstmt.setInt(1, index);
        pstmt.setInt(2, category_number);
        pstmt.setString(3, writer);
        pstmt.setString(4, title);
        pstmt.setString(5, content);
        pstmt.setString(6, fileName);
        pstmt.setDate(7, date);
        pstmt.setInt(8, view);
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
        String sql = "UPDATE POST SET View_count=? WHERE PNumber=?";
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

        closeConnection();
        return lectureList;
    }
}
