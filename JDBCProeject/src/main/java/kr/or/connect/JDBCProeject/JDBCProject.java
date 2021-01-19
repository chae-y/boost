package kr.or.connect.JDBCProeject;

import java.util.List;
import java.util.Scanner;

import kr.or.connect.JDBCProeject.dao.CARDDao;
import kr.or.connect.JDBCProeject.dto.CARD;

public class JDBCProject {

	public static void main(String[] args) {
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("-----------------------");
			System.out.println("1. 명함 입력");
			System.out.println("2. 명함 검색");
			System.out.println("3. 종료");
			System.out.println("-----------------------");
			System.out.print("메뉴를 입력하세요 : ");
			int num = scan.nextInt();
			if(num==1) {//명합입력
				scan.nextLine();
				System.out.print("이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("전화번호를 입력하세요 : ");
				String phone = scan.nextLine();
				System.out.print("회사 이름을 입력하세요 : ");
				String company = scan.nextLine();
				
				//데이터베이스에 저장
				CARD card= new CARD(name,phone,company);
				CARDDao dao = new CARDDao();
				int insertCount = dao.addCard(card);
				if(insertCount==1)	System.out.println("저장완료");
			}else if(num==2) {//명함검색
				scan.nextLine();
				System.out.print("검색할 이름을 입력하세요. (like검색) : ");
				String name_search = scan.nextLine();
				
				//데이터베이스에서 찾기
				CARDDao dao = new CARDDao();
				List<CARD> list = dao.getCard(name_search);
				for(CARD card: list) {
					System.out.println(card);
				}
			}else if(num==3) {//종료
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
