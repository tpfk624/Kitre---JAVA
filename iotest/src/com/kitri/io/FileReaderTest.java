package com.kitri.io;

import java.io.*;

public class FileReaderTest {
	
	public static void main(String[] args) {
		
		//파일 읽고 쓰는 예제
		FileReader fr = null;
		FileWriter fw = null; //파일 복사하기
		
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
			fw.write(str); //byte스트림은 바로바로 복사가 가능하지만 chracterstream은 파일을 반드시 닫아야 적혀짐
			
		} catch (FileNotFoundException e) { //파일이 없을 경우의 오류처리
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {//여기서 파일을 완전히 닫아야 복사가 완료됨
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
