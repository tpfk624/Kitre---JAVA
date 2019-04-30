package com.kitri.haksa.service.db;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	HaksaDto haksaDto;
	
	public HaksaServiceImpl() {
		haksaDto = new HaksaDto();
		
		while (true)
			menu();
	}

	@Override
	public void menu() {
		try {
			System.out.println("========== �޴� ���� ==========");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("----------------");
			System.out.println("0. ����");

			System.out.print("��ȣ�� ������ �ּ���..");
			switch (in.readLine()) {
				case "1" : registerMenu(); break;
				case "2" : findNameMenu(); break;
				case "3" : deleteMenu(); break;
				case "4" : selectAll(); break;
				case "0" : processExit(); break;
			}
			System.out.print("��� �Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է��� �ּ���");
			switch (in.readLine()) {
				case "1" : break;
				case "0" : processExit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registerMenu() {
		try {
			System.out.println("========== �޴� ���� ==========");
			System.out.println("1. �л�");
			System.out.println("2. ����");
			System.out.println("3. ������");
			System.out.println("4. �����޴�");
			System.out.println("----------------");

			System.out.print("��ȣ�� ������ �ּ���..");
			haksaDto.setKey(Integer.parseInt(in.readLine()));
			switch (haksaDto.getKey()) {
				case 4 : menu(); break;
				default :
					System.out.print("�� �� : ");
					haksaDto.setAge(Integer.parseInt(in.readLine()));
					System.out.print("�� �� : ");
					haksaDto.setName(in.readLine());
					System.out.print((haksaDto.getKey()==1 ? "�� �� : " : (haksaDto.getKey()==2 ? "�� �� : " : "�� �� : ")));
					haksaDto.setValue(in.readLine());
					HaksaDao.getInstance().register(haksaDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findNameMenu() {
		try {
			System.out.println("ã�� �̸��� �Է��� �ּ���.");
			System.out.print("�̸� : ");
			String name = in.readLine();
			haksaDto = HaksaDao.getInstance().findName(name);
			if(haksaDto != null)
				System.out.println("�̸� : " + haksaDto.getName() + "\t���� : " + haksaDto.getAge() + "\t" + haksaDto.getKeyName() + " : " + haksaDto.getValue());
			else
				System.out.println("�ش��ϴ� ����� �����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu() {
		try {
			System.out.println("������ ����� �̸��� �Է��� �ּ���.");
			System.out.print("�̸� : ");
			String name = in.readLine();
			System.out.println(name);
			int result = HaksaDao.getInstance().delete(name);
			if(result != 0)
				System.out.println(name + "���� �����Ͽ����ϴ�.");
			else
				System.out.println(name + "���� �����ϴµ� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectAll() {
		ArrayList<HaksaDto> all = HaksaDao.getInstance().selecArrayList();
		int size = all.size();
		if(size != 0) {
			for (int i = 0; i < size; i++) {
				System.out.println("�̸� : " + all.get(i).getName() + "\t���� : " + all.get(i).getAge() + "\t" + all.get(i).getKeyName() + " : " + all.get(i).getValue());
			}
		} else
			System.out.println("��ϵ� ����� �����ϴ�.");
	}

	@Override
	public void processExit() {
		System.exit(0);
	}
}
