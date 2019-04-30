package com.kitri.lang;

public class StringBufferTest1 {

	public static void main(String[] args) {
		
		//StringBuffer
		//16ĭ(��������)+6���� = 22 //StringBuffer�� �׻� 16ĭ�� ���������� �������´�.//���ڿ�����
		StringBuffer sb1 = new StringBuffer("hello ");
		System.out.println("1. sb1 == " + sb1);
		
		//capacity()
		int cap = sb1.capacity();
		System.out.println("�ʱ� ũ�� : " + cap +  "\t���ڿ� �� : " + sb1.length());
		
		//append()
		sb1.append("java"); //�ӽ���������̾ ������� ��� �ݿ���
		System.out.println("2. sb1 == " + sb1);
		sb1.append("!!!!!!");
		System.out.println("3. sb1 == " + sb1);
		cap = sb1.capacity();
		System.out.println("ũ�� : " + cap +  "\t���ڿ� �� : " + sb1.length());
		
		sb1.append("!!!!!!!");//ũ�⸦ �Ѿ�� �ڵ����� ũ�Ⱑ(��������) ��� �þ��
		System.out.println("4. sb1 == " + sb1);
		cap = sb1.capacity();
		System.out.println("ũ�� : " + cap +  "\t���ڿ� �� : " + sb1.length());
		System.out.println("----------------------------");
		
		//insert()
		sb1.insert(10, "@@@"); //10��° �ڸ��� @@@�� �����϶�
		System.out.println("5. sb1 == " + sb1);
		
		//delete()
		sb1.delete(10, 12); //a���� b������ ������
		System.out.println("6. sb1 == " + sb1);
		
		//deleteCharAt()
		sb1.deleteCharAt(10); //�ش��ϴ� ���� �ϳ��� ������
		System.out.println("7. sb1 == " + sb1);
		
		//replace()
		sb1.replace(6, 10, "�ڹ�"); //a���� b�������� �� ���ڷ� ��ü�϶�		
		System.out.println("8. sb1 == " + sb1);
		
		//reverse()
		sb1.reverse(); //���� ������	
		System.out.println("9. sb1 == " + sb1);
		sb1.reverse();
		
		//setCharAt()
		sb1.setCharAt(9, '@'); //�ϳ��� ���ڸ� �ٲ��
		System.out.println("10. sb1 == " + sb1);
		
		//��������Ҷ��� string�� �ٲ������
		//StringBuffer�� String�� �ٲٱ�(2�������)
		String s1 = new String(sb1);
		String s2 = sb1.toString();
		
		System.out.println("--------------------------");
		
		
		//����: hello java !!!�� �ٲٱ� or ����Ŭ�� �����ϴ�
		String str = "hello �ڹ�!!!";
		String findStr = "�ڹ�"; 
		//String findStr = "����Ŭ";
		String replaceStr = "java";
		
		int start = str.indexOf(findStr); //������
		System.out.println(start);
		
		if(start != -1) { //ã������ ������ -1����
			StringBuffer sb = new StringBuffer(str);
			int end = start + findStr.length();
			sb.replace(start, end, replaceStr);
			System.out.println(sb.toString());
		}else { 
			System.out.println(findStr + "�� �����ϴ�");
		}
		
		

		
		
		
		
		
		
		String s = "hello"; //string�� �ѹ� ����Ǹ� ����x
		s.concat("java");
		System.out.println("\n" + s);
	}
}
