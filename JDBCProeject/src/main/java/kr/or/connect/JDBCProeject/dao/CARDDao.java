package kr.or.connect.JDBCProeject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.connect.JDBCProeject.dto.CARD;

public class CARDDao {
	private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addCard(CARD card) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbpasswd);
			String sql = "INSERT INTO PROJECT1 VALUES (?, ?, ? ,now())";
			ps = conn.prepareStatement(sql);
			ps.setString(1,card.getName());
			ps.setString(2,card.getPhone());
			ps.setString(3,card.getCompany());
			
			insertCount = ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}
	
	public List<CARD> getCard(String search) {
		List<CARD> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbpasswd);;
			String sql = "SELECT * FROM PROJECT1 WHERE name like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+search+"%");
			rs = ps.executeQuery();//실행해주세요
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String company = rs.getString("companyName");
				Date date = rs.getTimestamp("createDate");
				CARD card = new CARD(name,phone,company,date);
				list.add(card);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
