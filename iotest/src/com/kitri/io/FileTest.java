package com.kitri.io;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;

		try {
			File infile = new File("e:\\iotest\\hello.txt");
			in = new FileInputStream(infile);
			long length = infile.length();
			byte b[] = new byte[(int) length];
			int x = in.read(b);//배열에 값을 읽어서 b에 넣어줌
			String str = new String(b, 0, x);
			System.out.println(x + "bytes read!!");
			System.out.println(str);

			// 파일카피본 만들기 //파일에다 써라
			File outfile = new File("e:\\iotest\\hello_copy.txt");
			out = new FileOutputStream(outfile);
			out.write(b);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 연결했으면 꼭 닫아줘야함
			try {
				if (in != null)//널포인트를 방지하기 위해
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
