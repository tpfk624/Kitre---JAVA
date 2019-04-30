package com.kitri.io.my;

import java.io.*;

public class FileTest {
	
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;

	try {
		File infile = new File("e:\\iotest\\sera.txt");
		in = new FileInputStream(infile);
		long length = infile.length();
		byte b[] = new byte[(int)length];
		int x = in.read(b);
		String str = new String(b, 0, x);
		System.out.println(str);
		
		//파일 카피본만들기
		File outfile = new File("e:\\iotest\\sera_copy.txt");
		out = new FileOutputStream(outfile);
		out.write(b);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

	}
}
