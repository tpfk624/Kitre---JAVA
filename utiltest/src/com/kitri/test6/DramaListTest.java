package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		List<Drama> list = new ArrayList<Drama>(); 
	
//		���1		
//		Drama d1 = new Drama("�� �ܿ�, �ٶ��� �д�.", "SBS", "�����", "���μ�", "������");
//		Drama d2 = new Drama("����� ����", "MBC", "�ּ���");
//		Drama d3 = new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
//		Drama d4 = new Drama("�ְ�� �̼���", "KBS", "������", null, "������");
		
//		list.add(d1);
//		list.add(d2);
//		list.add(d3);
//		list.add(d4);
//	
		
		//ª�� ���		
		list.add(new Drama("�� �ܿ�, �ٶ��� �д�.", "SBS", "�����", "���μ�", "������"));
		list.add(new Drama("����� ����", "MBC", "�ּ���"));
		list.add(new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���"));
		list.add(new Drama("�ְ�� �̼���", "KBS", "������", null, "������"));
	
		System.out.println("<< ArrayList�� �̿��� ��� ����>>");
		System.out.println("����\t��ۻ�\t����\t����\t����");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println((i+1) +"." + list.get(i) + "\n");
		}

	}
}
