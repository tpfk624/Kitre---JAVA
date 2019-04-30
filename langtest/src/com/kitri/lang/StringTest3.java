package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {
		
		//charAt()
		String str = "hello java!!";
		char c = str.charAt(4);
		System.out.println("c == " + c);
		
		str = "123";
		int x = str.charAt(0) - 48; //'1'�� char�� ������ �ƽ�Ű�ڵ尪�� 49�� ���� -48�ؼ� 1�� ����� 
		System.out.println("x == " + x);
		
		str = "1a3";
		int len = str.length();
		System.out.println("length == " + len);
		
		
		//����Թ���
		String result = "�����Դϴ�";
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				result = " ���ڰ� �ƴմϴ�";
				break;
			}
		}
		System.out.println(str + "��" + result);
		
		//���� Ǭ ��
		str = "1a3";
		String find = null;
		for(int i = 0; i < len ; i++) {
			if(str.charAt(i) > 65) {
				find = "����";
			}
		}
		if(find != "����") {
			System.out.println(str + "�� �����Դϴ�" );
		}else {
			System.out.println(str + "�� ���ڰ� �ֽ��ϴ�" );
		}
		System.out.println("-----------------------");
		
		//�˾Ƹ� �α�
		//concat(String str)
		String str1 = "hello ";
		String str2 = "java";
		System.out.println(str1 + str2);
		System.out.println(str1.concat(str2));
		System.out.println("-----------------------");
		
		
		//startsWith(), endsWith()
		str = "hello java!!";
		if(str.startsWith("h")) //����
			System.out.println(str + "�� h�� �����Ѵ�");
		if(str.endsWith("!!")) //�� //���ڿ��� ����
			System.out.println(str + "�� !!�� ������");
		System.out.println("-----------------------");
		
		
		//toUpperCase(), s2.toLowerCase() //string�� ����
		String s1 = "jAva";
		String s2 = "JavA"; 
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase()); //�빮��
		System.out.println("s2.toLowerCase() == " + s1.toLowerCase()); //�ҹ���
		if(s1.equals(s2))
			System.out.println(s1 + "��" + s2 + "�� ���� ���ڿ��̴�");
		else
			System.out.println(s1 + "��" + s2 + "�� �ٸ� ���ڿ��̴�");
		System.out.println("-----------------------");
		
		
	
		
		//equalsIgnoreCase()
		if((s1.equalsIgnoreCase(s2)))//���ĺ����� ��
			System.out.println(s1 + "��" + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�");
		else
			System.out.println(s1 + "��" + s2 + "�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�");
		
		//�ΰ� ��� ���� �ɷ� �����ϱ�
		if((s1.toUpperCase().equals(s2.toUpperCase())))
			System.out.println(s1 + "��" + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�");
		else
			System.out.println(s1 + "��" + s2 + "�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�");
		System.out.println("-----------------------");
		
	}
}
