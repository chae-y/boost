package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JCDBCExam5 {

	public static void main(String[] args) {
		int roleid=500;
		
		RoleDao dao = new RoleDao();
		
		int deleteCount = dao.deleteRole(roleid);
		
		System.out.println(deleteCount);
	}
}
