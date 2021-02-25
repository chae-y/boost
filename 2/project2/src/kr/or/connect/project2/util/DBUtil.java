package kr.or.connect.project2.util;

import java.sql.*;

public class DBUtil {
	
	 public static Connection getConnection(){
	        // 본인 database에 맞게끔 수정해주세요.
		 	String dbUrl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC";
			String dbUser = "connectuser";
			String dbpasswd = "connect123!@#";
	        return getConnection(dbUrl, dbUser, dbpasswd);
	 }
	 
	public static Connection getConnection(String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println("ds");
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
