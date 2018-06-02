package Action;

import java.sql.*;

public class CommonDao {
    private final String driverName = "com.mysql.jdbc.Driver"; //DB driver
    private final String url = "jdbc:mysql://localhost:3306/university?useSSL=false"; //DB url
    private final String id = "root";
    private final String pw = "1234";
    private Connection con=null;

    //db접속정보를 가시조, 접속후에 SQL문을 사용하기위해 필요한 statement객체를 반환하는 openConnection 메소드를 구현합니다.
    public Connection openConnection(){
        try{
            Class.forName(driverName);
            con=DriverManager.getConnection(url,id,pw);
        }catch(Exception e){
            System.err.println("Database Connection Error...");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    //접속을 종료하기위한 closeConnection 메소드를 구현합니다.
    public void closeConnection(){
        try {
            if(!con.isClosed()) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
