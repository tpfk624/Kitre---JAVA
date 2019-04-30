package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {// 쓰레드 상속말고

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();

	public ChatServer() {
//		ServerSocket ss = null;//전역으로
		try {
			ss = new ServerSocket(ChatConstance.PORT);// 포트번호//포트를 열고 클라이언트 기다림
			System.out.println("클라이언트 접속 대기중...............");// 여기서 에러가 나면 포트번호 바꿔야함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {// 클라이언트 접속처리
		while (true) { // 무한루프돌리기
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트 접속 성공: " + socket);
				new ChatClient(socket).start(); // 상속받아서 쓰레드이니 바로 시작하기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ChatClient extends Thread { // innerclass //바깥에 있는 거 자기것마냥 사용가능

		String name;
		BufferedReader in;
		OutputStream out;
		Socket socket;
		

		public ChatClient(Socket socket) {
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 3. IO(BufferReader
																						// OutputStream) 생성
				out = socket.getOutputStream();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {// 클라이언트 메세지처리
			boolean flag = true;
			while (flag) { // 무한루프
				try {
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지: " + msg);// protocol|메세지형식.....
					StringTokenizer st = new StringTokenizer(msg, "|"); //문자 나누기
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT: {
//						100|안효인
						name = st.nextToken(); // 안효인 //접속시 이름에 지정이 된다
						
//						int size = list.size();
//						for (int i = 0; i < size; i++) {
//							chatClient cc = list.get(i);
//						}

						// 향상된 for문 - 위와 같음
					    // 나를 제외한 나머지사람들에게 내가 들어왔다고 알림
						multicast((ChatConstance.SC_CONNECT + "|" + name));
						list.add(this); // 이제는 나를 포함
						for (ChatClient cc : list) { // 이번에는 cc가아닌 this //나한테 각각의 대화명을 보내라
							unicast((ChatConstance.SC_CONNECT + "|" + cc.name));
						}
					}break;
					case ChatConstance.CS_ALL: {
//							200|안녕하세요
						String tmp = st.nextToken(); // 안녕하세요
					 // 나를 제외한 나머지사람들에게 내가 들어왔다고 알림
							multicast((ChatConstance.SC_MESSAGE + "|[" + name + "] " + tmp ));
						
					}break;
					case ChatConstance.CS_TO: {
//						250|홍길동|안녕
						String to = st.nextToken(); //홍길동
						String tmp = st.nextToken(); //안녕?
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_MESSAGE + "|☆" + name + "☆" + tmp);
								break;
							}
						}
					}break;
					case ChatConstance.CS_PAPER: {
//						300|대상자|메세지
						String to = st.nextToken(); //대상자
						String tmp = st.nextToken(); //메세지
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
//								300|보낸사람대화명|메세지
								cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);
								break;
							}
						}
						
					}break;
					case ChatConstance.CS_RENAME: {
//						대화명변경 : 400|새로운 대화명
						String newid = st.nextToken(); //변경할 대화명
//						대화명변경:  400|변경전대화명|변경할대화명
						multicast(ChatConstance.SC_RENAME + "|" + name + "|" + newid);
						name = newid; //이거를 해야 대화명이 변경됨
					}break;
					
					case ChatConstance.CS_DISCONNECT: {
//						900|
						multicast(ChatConstance.SC_DISCONNECT + "|" + name);//나를 포함한 모든 사람에게 보내고
						list.remove(this);//리스트에서 나를 빼라
						flag = false; //스위치케이스여서 브레이크를 못하니 플래그사용
						in.close();//얘네가 null이었으면 여기까지 들어오지도 못했을거라 if문 안돌리고 닫기함
						out.close();
						socket.close();
						
					}break;
					}
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}

		}
		private void multicast(String msg) { // 모든사람에게 메세지보낼ㄷ대
			for (ChatClient cc : list) {
				cc.unicast(msg);
			}
			
		}

		private void unicast(String msg) { // 특정사람에게 메시지보낼때
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
	}

	

	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);
//		t.start(); //쓰레드 시작

		// 한줄로 바꾸기
		new Thread(new ChatServer()).start(); // start만 할거라 익명으로 객체 생성

	}

}
