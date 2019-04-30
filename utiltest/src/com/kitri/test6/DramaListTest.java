package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		List<Drama> list = new ArrayList<Drama>(); 
	
//		방법1		
//		Drama d1 = new Drama("그 겨울, 바람이 분다.", "SBS", "김규태", "조인성", "송혜교");
//		Drama d2 = new Drama("백년의 유산", "MBC", "주성우");
//		Drama d3 = new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해");
//		Drama d4 = new Drama("최고다 이순신", "KBS", "윤성식", null, "아이유");
		
//		list.add(d1);
//		list.add(d2);
//		list.add(d3);
//		list.add(d4);
//	
		
		//짧은 방법		
		list.add(new Drama("그 겨울, 바람이 분다.", "SBS", "김규태", "조인성", "송혜교"));
		list.add(new Drama("백년의 유산", "MBC", "주성우"));
		list.add(new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해"));
		list.add(new Drama("최고다 이순신", "KBS", "윤성식", null, "아이유"));
	
		System.out.println("<< ArrayList를 이용한 드라마 정보>>");
		System.out.println("제목\t방송사\t감독\t남주\t여주");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println((i+1) +"." + list.get(i) + "\n");
		}

	}
}
