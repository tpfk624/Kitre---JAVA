package test_dtodao;

import java.sql.Date;
import java.util.*;

public class goodMain {

	public static void main(String[] args) {
		DAO dao = DAO.sharedInstance();// daoŸ���� obj�� ��ü�� �����ϴ� �޼ҵ�

//		 ���� �޼��� �ǽ�
		Good dto = new Good();
		dto.setCode("100");
		dto.setName("õ�Ͽ�");
		dto.setManufacture("�žȱ�");
		dto.setPrice(10000);

//		// ���� �޼��� �ǽ�
//		Good dto = new Good();
//		dto.setName("����");
//		dto.setManufacture("�žȱ�");
//		dto.setPrice(10000);
//		dto.setCode("100");

		
		// 2019�� 4�� 8���� java.sql.DateŸ���� ��ü�� ����
		Calendar cal = new GregorianCalendar(2019, 04, 10);
		Date date = new Date(cal.getTimeInMillis());
		dto.setMakingdate(date);
		boolean r = dao.InsertGood(dto);// ���Ը޼��� ����
//
		if (r) {
			System.out.println("���Կ� �����߽��ϴ�.");
		} else {
			System.out.println("���Կ� �����߽��ϴ�.");
		}

//		boolean e = dao.EditGood(dto);
//		if(e) {
//			System.out.println("������ �����߽��ϴ�.");
//		} else {
//			System.out.println("������ �����߽��ϴ�.");
//		}
		
		
		// list�� ��� �����Ϳ� ����
		List<Good> list = dao.getList();

		// ���
		for (Good good : list) {// for(�ڷ��� ���� : �迭�̸�){} : �迭�� ���� �ϳ��ϳ� �ڷ��� ������ �־�� {}����
			// ����ϴ� �޼��忡 ������ ������ ����ϸ� �������̵��� toString()�޼��尡 ȣ���
			System.out.println(good);
		}
	}
}
