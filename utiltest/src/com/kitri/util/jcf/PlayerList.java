package com.kitri.util.jcf;

import java.util.*;

public class PlayerList {
	
//	List<PlayerDto> list = new ArrayList<PlayerDto>();
	List<PlayerDto> list = new Vector<PlayerDto>(); //���͸� ����ص� �������(���Ϳ� �޼ҵ尡 �� ������ �ֿ�޼ҵ�� ����Ʈ�� �ִ�)
	
	private void playerResiter(PlayerDto playerDto) {
		list.add(playerDto);
	}
	
	private void playerList() { //����Ʈ�̾Ƴ���?
		System.out.println("=== �λ� ��� �� ��� ===");
		System.out.println("------------------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private PlayerDto playerSearch(int number) { //���ã��
		PlayerDto playerDto = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			PlayerDto dto = list.get(i);
			if (number == dto.getNumber()) {
				playerDto = dto;
				break;
			}
		}
		return playerDto;
	}
	
	private void playerInfo(PlayerDto playerDto) {
		if(playerDto != null)
			System.out.println(playerDto);
		else
			System.out.println("������ �����ϴ�");
	}
	
	
	
	public static void main(String[] args) {
		PlayerList pl = new PlayerList();
			
		pl.playerResiter(new PlayerDto(24, "�����", 4, 0.321));
		pl.playerResiter(new PlayerDto(13, "����", 5, 0.351));
		pl.playerResiter(new PlayerDto(13, "����", 5, 0.351));
		pl.playerResiter(new PlayerDto(9, "�丣������", 3, 0.0421));
		pl.playerResiter(new PlayerDto(38, "�����", 7, 0.384));

		pl.playerList();

		int number = 38;
		System.out.println(number + "�� ���� ����!!");
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);
		
		
		number = 13;
		double score = 0.357;
		System.out.println(number + "�� ������ ��Ÿ!!! Ÿ���� "+ score + "�� ���� ");
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		pl.playerInfo(playerDto);
		
		pl.playerList();
		
		//����Ʈ ����,�迭 ���� ������ �ٲ㵵 �ּҰ��� �ҷ����� ���̱� ������ ������ �ٲ���ִ�
		//���۷����� �������� ��ü�� ������ �ƴϱ� �����̴�. (�ſ� �߿�)
		
		
	}
}
