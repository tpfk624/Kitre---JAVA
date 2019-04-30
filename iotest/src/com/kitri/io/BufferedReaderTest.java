package com.kitri.io;

import java.io.*;

//���� �������� ���� ���� �� ���۰� �����ϱ�(�׷��� ����Ʈ �˱� �ؾ� ��)

public class BufferedReaderTest {

	public static void main(String[] args) {

		BufferedReader fin = null;// ���ڿ������� ����
		FileWriter fw = null; // ī�� //����� string�� ���� �޼ҵ尡 ���� ���� ���۵�����ͻ��x
		
		try {
//			InputStream is = System.in; //3
//			Reader r = new InputStreamReader(is);  //2
//			BufferedReader in = new BufferedReader(r); //1

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // �� ���������� �ٿ��� ��尡 ���� ��𿡼� �д���
																						// �ý��ۿ��� ������
			System.out.print("���� �����̸� : ");
			String infile = in.readLine(); // ���͸� �������� �о����(����������, ����)
			// System.out.println("in file == " + infile);

			System.out.print("������ �����̸� : ");
			String outfile = in.readLine();
			fw = new FileWriter(new File(outfile));

			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(infile)))); // ���Ͽ��� ������ ������ǲ��Ʈ��
			String str = null;
			while ((str = fin.readLine()) != null) {
				System.out.println(str);
				fw.write(str + "\r\n"); // ���;��� ���ٷ� ������ \r\n�����߰�
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {// ���⼭ ������ ������ �ݾƾ� ���簡 �Ϸ��
				if (fw != null)
					fw.close();
				if (fin != null)
					fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
