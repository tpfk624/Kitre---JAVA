package test_dtodao;

import java.sql.Date;
import java.util.*;

public class goodMain {

	public static void main(String[] args) {
		DAO dao = DAO.sharedInstance();// dao타입의 obj에 객체를 생성하는 메소드

//		 삽입 메서드 실습
		Good dto = new Good();
		dto.setCode("100");
		dto.setName("천일염");
		dto.setManufacture("신안군");
		dto.setPrice(10000);

//		// 수정 메서드 실습
//		Good dto = new Good();
//		dto.setName("망고");
//		dto.setManufacture("신안군");
//		dto.setPrice(10000);
//		dto.setCode("100");

		
		// 2019년 4월 8일을 java.sql.Date타입의 객체로 생성
		Calendar cal = new GregorianCalendar(2019, 04, 10);
		Date date = new Date(cal.getTimeInMillis());
		dto.setMakingdate(date);
		boolean r = dao.InsertGood(dto);// 삽입메서드 실행
//
		if (r) {
			System.out.println("삽입에 성공했습니다.");
		} else {
			System.out.println("삽입에 실패했습니다.");
		}

//		boolean e = dao.EditGood(dto);
//		if(e) {
//			System.out.println("수정에 성공했습니다.");
//		} else {
//			System.out.println("수정에 실패했습니다.");
//		}
		
		
		// list의 모든 데이터에 접근
		List<Good> list = dao.getList();

		// 출력
		for (Good good : list) {// for(자료형 변수 : 배열이름){} : 배열의 값을 하나하나 자료형 변수에 넣어가며 {}실행
			// 출력하는 메서드에 참조형 변수를 사용하면 오버라이드한 toString()메서드가 호출됨
			System.out.println(good);
		}
	}
}
