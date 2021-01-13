package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	public Role getRole(Integer roleId) {
		String dbUrl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC";
		String dbUser = "connectuser";
		String dbpasswd = "connect123!@#";
		
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUser, dbpasswd);;
			String sql = "SELECT role_id,description FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,roleId);
			rs = ps.executeQuery();//실행해주세요
			if(rs.next()) {
				int id = rs.getInt(1);
				String description = rs.getString("description");
				role = new Role(id,description);
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
		
		return role;
	}
}
