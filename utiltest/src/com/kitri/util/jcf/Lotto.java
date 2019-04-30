package com.kitri.util.jcf;

import java.util.*;

public class Lotto {
	//로또만들기
	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while(true) { //무한루프
			set.add(random.nextInt(45) + 1);
			if(set.size() == 6)
				break;
		}
		Integer number[] = set.toArray(new Integer[0]);
		int len = number.length;
		for (int i = 0; i < len; i++) {
			System.out.println(number[i]);
		}

	}
}
