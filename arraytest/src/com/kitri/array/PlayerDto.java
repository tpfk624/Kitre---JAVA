package com.kitri.array;

//Dto : Data Transfer Object �����͸� �����ִ� ��ü
//Vo : Value Object
//Bean

public class PlayerDto {
	
	private int number;
	private String name;
	private int position; //����:1, ����:2
	private double grade;
	private String positionName[] = {"����Ÿ��", "����", "����", "1���", "2���", "3���", "���ݼ�", "���ͼ�", "�߰߼�", "���ͼ�"}; 
	
	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;		
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		//���⿡ �迭�� ����� �迭�� ��� ȣ��Ǵ� ����������
		return "PlayerDto [���ȣ=" + number + "\t������=" + name + "\t\t������=" + positionName[position] + 
				"\t" + (position != 1 ? "Ÿ��" : "�����")     + "=" + grade + "]";
	}
		
	//����Ÿ��, ����, ����, 1���, 2���, 3���, ���ݼ�, �ܾ߼�(���ͼ�, �߰߼�, ���ͼ�) 
	// 0		1		2	3		4		5		6				7		8		9
	//Ÿ��: Ÿ��, ����:�����	
}
