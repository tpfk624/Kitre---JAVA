package com.kitri.util.jcf;

import java.util.*;


public class MapTest {
	public static void main(String[] args) {
		
//		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>(); //�� ������ƮŸ���̾����(��Ʈ���� ���� ��)
		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>();//������� 
		map.put("DS24", new PlayerDto(24, "�����", 4, 0.321));//map�� �ڿ� ������ �տ� Ű ���� �߿��ϴ� �ߺ��̸� ���
		map.put("DS9", new PlayerDto(9, "�丣������", 3, 0.421) );
		map.put("KW24", new PlayerDto(9, "�ں�ȣ", 3, 0.431));
		map.put("HH19", new PlayerDto(9, "���ٿ�", 7, 0.321));
		
		int size = map.size();
		System.out.println("��� �ο� :" + size);
		
		int number = 24;
		System.out.println("�λ��� " + number + "�� ������ ����!!");
		PlayerDto playerDto = map.get("DS" + number); //�÷��ǿ����� �ε����� �������µ� �ʿ����� Ű������
		System.out.println(playerDto);//���� ���� � ���� �־����� ����ؾ���
		
		
		
		
		
	}
}
