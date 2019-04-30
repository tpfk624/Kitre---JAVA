package com.kitri.array;

//Dto : Data Transfer Object 데이터를 보내주는 객체
//Vo : Value Object
//Bean

public class PlayerDto {
	
	private int number;
	private String name;
	private int position; //투수:1, 포수:2
	private double grade;
	private String positionName[] = {"지명타자", "투수", "포수", "1루수", "2루수", "3루수", "유격수", "좌익수", "중견수", "우익수"}; 
	
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
		//여기에 배열을 만들면 배열이 계속 호출되니 전역변수로
		return "PlayerDto [등번호=" + number + "\t선수명=" + name + "\t\t포지션=" + positionName[position] + 
				"\t" + (position != 1 ? "타율" : "방어율")     + "=" + grade + "]";
	}
		
	//지명타자, 투수, 포수, 1루수, 2루수, 3루수, 유격수, 외야수(좌익수, 중견수, 우익수) 
	// 0		1		2	3		4		5		6				7		8		9
	//타자: 타율, 투수:방어율	
}
