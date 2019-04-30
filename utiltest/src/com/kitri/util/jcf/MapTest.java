package com.kitri.util.jcf;

import java.util.*;


public class MapTest {
	public static void main(String[] args) {
		
//		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>(); //앞 오브젝트타입이어야함(스트링을 자주 씀)
		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>();//결과같음 
		map.put("DS24", new PlayerDto(24, "오재원", 4, 0.321));//map은 뒤에 값보다 앞에 키 값이 중요하다 중복이면 덮어씀
		map.put("DS9", new PlayerDto(9, "페르난데스", 3, 0.421) );
		map.put("KW24", new PlayerDto(9, "박병호", 3, 0.431));
		map.put("HH19", new PlayerDto(9, "정근우", 7, 0.321));
		
		int size = map.size();
		System.out.println("등록 인원 :" + size);
		
		int number = 24;
		System.out.println("두산의 " + number + "번 선수의 정보!!");
		PlayerDto playerDto = map.get("DS" + number); //컬렉션에서는 인덱스로 가져오는데 맵에서는 키값으로
		System.out.println(playerDto);//맵은 내가 어떤 값을 넣었는지 기억해야함
		
		
		
		
		
	}
}
