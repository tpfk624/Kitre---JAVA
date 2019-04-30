package com.kitri.util.jcf;

import java.util.*;

public class PlayerList {
	
//	List<PlayerDto> list = new ArrayList<PlayerDto>();
	List<PlayerDto> list = new Vector<PlayerDto>(); //벡터를 사용해도 결과같음(벡터에 메소드가 더 많지만 주요메소드는 리스트에 있다)
	
	private void playerResiter(PlayerDto playerDto) {
		list.add(playerDto);
	}
	
	private void playerList() { //리스트뽑아내기?
		System.out.println("=== 두산 베어스 팀 명단 ===");
		System.out.println("------------------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private PlayerDto playerSearch(int number) { //사람찾기
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
			System.out.println("선수는 없습니다");
	}
	
	
	
	public static void main(String[] args) {
		PlayerList pl = new PlayerList();
			
		pl.playerResiter(new PlayerDto(24, "오재원", 4, 0.321));
		pl.playerResiter(new PlayerDto(13, "허경민", 5, 0.351));
		pl.playerResiter(new PlayerDto(13, "허경민", 5, 0.351));
		pl.playerResiter(new PlayerDto(9, "페르난데스", 3, 0.0421));
		pl.playerResiter(new PlayerDto(38, "김대한", 7, 0.384));

		pl.playerList();

		int number = 38;
		System.out.println(number + "번 선수 정보!!");
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);
		
		
		number = 13;
		double score = 0.357;
		System.out.println(number + "번 선수가 안타!!! 타율이 "+ score + "로 변경 ");
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		pl.playerInfo(playerDto);
		
		pl.playerList();
		
		//리스트 저장,배열 등은 정보를 바꿔도 주소값을 불러오는 것이기 때문에 정보가 바뀌어있다
		//래퍼런스의 저장이지 객체의 저장이 아니기 때문이다. (매우 중요)
		
		
	}
}
