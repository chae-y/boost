package kr.or.connect.project2.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import kr.or.connect.project2.dto.Guestbook;
import kr.or.connect.project2.util.DBUtil;

public class GuestbookDao {
	public List<Guestbook> getGuestbooks(){
		List<Guestbook> list = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM guestbook";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				Date date = rs.getTimestamp("regdate");
				Guestbook gb = new Guestbook(id, name, content, date);
				list.add(gb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addGuestbook(Guestbook guestbook) {
		//작성
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO guestbook(name,content,regdate) VALUES(?, ?, now())";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,guestbook.getName());
			ps.setString(2,guestbook.getContent());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!= null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
