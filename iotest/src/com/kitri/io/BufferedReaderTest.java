package com.kitri.io;

import java.io.*;

//위에 예제들은 대충 봐도 됨 버퍼가 있으니까(그래도 바이트 알긴 해야 함)

public class BufferedReaderTest {

	public static void main(String[] args) {

		BufferedReader fin = null;// 문자열단위로 받음
		FileWriter fw = null; // 카피 //출력은 string을 쓰는 메소드가 많아 굳이 버퍼드라이터사용x
		
		try {
//			InputStream is = System.in; //3
//			Reader r = new InputStreamReader(is);  //2
//			BufferedReader in = new BufferedReader(r); //1

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 맨 마지막에는 근원지 노드가 나옴 어디에서 읽는지
																						// 시스템에서 읽으니
			System.out.print("읽을 파일이름 : ");
			String infile = in.readLine(); // 엔터를 기준으로 읽어들임(엔터전까지, 한줄)
			// System.out.println("in file == " + infile);

			System.out.print("복사할 파일이름 : ");
			String outfile = in.readLine();
			fw = new FileWriter(new File(outfile));

			fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(infile)))); // 파일에서 읽으니 파일인풋스트림
			String str = null;
			while ((str = fin.readLine()) != null) {
				System.out.println(str);
				fw.write(str + "\r\n"); // 엔터없이 한줄로 나오니 \r\n엔터추가
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {// 여기서 파일을 완전히 닫아야 복사가 완료됨
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
