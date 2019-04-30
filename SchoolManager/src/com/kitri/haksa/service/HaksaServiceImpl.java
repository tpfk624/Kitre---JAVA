package com.kitri.haksa.service;

import java.io.*;
import java.util.*;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

//	private static final char[] S = null;

	List<HaksaDto> list = new ArrayList<HaksaDto>();
	String job[] = { "�й�", "����", "�μ�" };
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);

	public HaksaServiceImpl() {
		super();
	}

	@Override
	public void menu() {
		ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
		while (true) {
			
		
		System.out.println("===========�޴�����===============");
		System.out.println("1.��� ");
		System.out.println("2.ã�� ");
		System.out.println("3.���� ");
		System.out.println("4.��ü��� ");
		System.out.println("-------------------");
		System.out.println("0. ����");
		System.out.println("------------------");
		System.out.println("��ȣ�� �������ּ���");

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

		System.out.println("===========�޴�����===============");
		System.out.println("1.�л� ");
		System.out.println("2.���� ");
		System.out.println("3.������ ");
		System.out.println("4.�����޴� ");
		System.out.println("��ȣ�� �������ּ���");

		try {
			String key = in.readLine();
			System.out.print("����: ");
			String age = in.readLine();
			System.out.print("�̸�: ");
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
		System.out.println("ã�� �̸��� �Է����ּ���");
		System.out.print("�̸� : ");
		String name;
		try {
			name = in.readLine();
			HaksaDto hd = findName(name);
			if(hd.equals(null)) {
				System.out.println("���� ȸ���Դϴ�");
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
	public void deleteMenu() { // ȸ������
		System.out.println("������ ����� �̸��� �Է����ּ���");
		System.out.print("�̸� : ");
		String name;
		try {
			name = in.readLine();
			int hd = delete(name);//int�� �޾ƿ����ϱ� int�� �ֱ�
			if(hd.equals(null)) {
				System.out.println("���� ȸ���Դϴ�");
			}else{
				list.remove(hd);
				System.out.println("�����Ϸ�");
				processExit();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int delete(String name) { // ȸ�������ϱ�
		HaksaDto hd = null;
		int len = name.length();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getName().equals(name)) {
				hd = list.get(i);
//				list.remove(i);
//				System.out.println("�����Ϸ�");
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
			System.out.println("����Ϸ��� 1, �����Ϸ��� 0�� �����ʽÿ�");
			try {
				String i = in.readLine();
				if (i.equals("1")) {
					break;
				} else if (i.equals("0")) {
					System.out.println("���α׷��� ����ƽ��ϴ�");
					System.exit(0);
				} else {
					System.out.println("�ٸ� ���ڸ� �Է��ϼ̽��ϴ�");
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
