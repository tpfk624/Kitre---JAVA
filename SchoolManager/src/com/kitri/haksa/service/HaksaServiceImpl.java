package com.kitri.haksa.service;

import java.io.*;
import java.util.*;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

//	private static final char[] S = null;

	List<HaksaDto> list = new ArrayList<HaksaDto>();
	String job[] = { "학번", "과목", "부서" };
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);

	public HaksaServiceImpl() {
		super();
	}

	@Override
	public void menu() {
		ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
		while (true) {
			
		
		System.out.println("===========메뉴선택===============");
		System.out.println("1.등록 ");
		System.out.println("2.찾기 ");
		System.out.println("3.삭제 ");
		System.out.println("4.전체출력 ");
		System.out.println("-------------------");
		System.out.println("0. 종료");
		System.out.println("------------------");
		System.out.println("번호를 선택해주세요");

		try {
			String i = in.readLine();
			switch (i) {
			case "0":
				processExit();
			case "1":
				registerMenu();
				break;
			case "2":
				findNameMenu();
				break;
			case "3":
				deleteMenu();
				break;
			case "4":
				selectAll();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

	@Override
	public void registerMenu() {

		System.out.println("===========메뉴선택===============");
		System.out.println("1.학생 ");
		System.out.println("2.교수 ");
		System.out.println("3.관리자 ");
		System.out.println("4.이전메뉴 ");
		System.out.println("번호를 선택해주세요");

		try {
			String key = in.readLine();
			System.out.print("나이: ");
			String age = in.readLine();
			System.out.print("이름: ");
			String name = in.readLine();
			System.out.print(job[Integer.valueOf(key) - 1]);
			String value = in.readLine();
			HaksaDto hd = new HaksaDto(Integer.valueOf(age), name, Integer.valueOf(key), value);
			register(hd);
			processExit();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void register(HaksaDto haksa) {
		list.add(haksa);
		System.out.println("list == " + haksa.getAge() + haksa.getName() + haksa.getValue());
	}

	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해주세요");
		System.out.print("이름 : ");
		String name;
		try {
			name = in.readLine();
			HaksaDto hd = findName(name);
			if(hd.equals(null)) {
				System.out.println("없는 회원입니다");
			}else{
				System.out.println("list == " + hd.getAge() + hd.getName() + hd.getValue());
				processExit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HaksaDto findName(String name) {
		HaksaDto hd = null;
		int len = name.length();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getName().equals(name)) {
				hd = list.get(i);
				break;
			}
		}
		return hd;
	}

	@Override
	public void deleteMenu() { // 회원삭제
		System.out.println("삭제할 사람의 이름을 입력해주세요");
		System.out.print("이름 : ");
		String name;
		try {
			name = in.readLine();
			int hd = delete(name);//int로 받아왔으니까 int로 주기
			if(hd.equals(null)) {
				System.out.println("없는 회원입니다");
			}else{
				list.remove(hd);
				System.out.println("삭제완료");
				processExit();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int delete(String name) { // 회원삭제하기
		HaksaDto hd = null;
		int len = name.length();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getName().equals(name)) {
				hd = list.get(i);
//				list.remove(i);
//				System.out.println("삭제완료");
				break;
			}
		}
		return hd;
	}

	@Override
	public void selectAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		menu();
	}

	@Override
	public void processExit() {
		while (true) {
			System.out.println("계속하려면 1, 종료하려면 0을 누르십시오");
			try {
				String i = in.readLine();
				if (i.equals("1")) {
					break;
				} else if (i.equals("0")) {
					System.out.println("프로그램이 종료됐습니다");
					System.exit(0);
				} else {
					System.out.println("다른 숫자를 입력하셨습니다");
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private int getNumber() {

		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

}
