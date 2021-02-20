package kr.or.connect.project2.util;

import java.sql.*;

public class DBUtil {
	
	 public static Connection getConnection(){
	        // 본인 database에 맞게끔 수정해주세요.
	        return getConnection("jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC","connectuser","connect123!@#");
	 }
	 
	public static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
