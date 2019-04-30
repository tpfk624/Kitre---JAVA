package com.kitri.io;

import java.io.*;

public class FileReaderTest {
	
	public static void main(String[] args) {
		
		//���� �а� ���� ����
		FileReader fr = null;
		FileWriter fw = null; //���� �����ϱ�
		
		try {
			File infile = new File("e:\\iotest\\hello.txt");
			fr = new FileReader(infile);
			long length = infile.length();
			char c[] = new char[(int) length];
			int x = fr.read(c);
			System.out.println(x + "characters read!!!");
			String str = new String(c);
			System.out.println(c);
			
			File outfile = new File("e:\\iotest\\hello_copy2.txt");
			fw = new FileWriter(outfile);
			fw.write(str); //byte��Ʈ���� �ٷιٷ� ���簡 ���������� chracterstream�� ������ �ݵ�� �ݾƾ� ������
			
		} catch (FileNotFoundException e) { //������ ���� ����� ����ó��
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {//���⼭ ������ ������ �ݾƾ� ���簡 �Ϸ��
					if(fw != null)
						fw.close();
					if(fr != null)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
}
