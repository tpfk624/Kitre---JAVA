package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {// ������ ��Ӹ���

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();

	public ChatServer() {
//		ServerSocket ss = null;//��������
		try {
			ss = new ServerSocket(ChatConstance.PORT);// ��Ʈ��ȣ//��Ʈ�� ���� Ŭ���̾�Ʈ ��ٸ�
			System.out.println("Ŭ���̾�Ʈ ���� �����...............");// ���⼭ ������ ���� ��Ʈ��ȣ �ٲ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {// Ŭ���̾�Ʈ ����ó��
		while (true) { // ���ѷ���������
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ����: " + socket);
				new ChatClient(socket).start(); // ��ӹ޾Ƽ� �������̴� �ٷ� �����ϱ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ChatClient extends Thread { // innerclass //�ٱ��� �ִ� �� �ڱ�͸��� ��밡��

		String name;
		BufferedReader in;
		OutputStream out;
		Socket socket;
		

		public ChatClient(Socket socket) {
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 3. IO(BufferReader
																						// OutputStream) ����
				out = socket.getOutputStream();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {// Ŭ���̾�Ʈ �޼���ó��
			boolean flag = true;
			while (flag) { // ���ѷ���
				try {
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼���: " + msg);// protocol|�޼�������.....
					StringTokenizer st = new StringTokenizer(msg, "|"); //���� ������
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT: {
//						100|��ȿ��
						name = st.nextToken(); // ��ȿ�� //���ӽ� �̸��� ������ �ȴ�
						
//						int size = list.size();
//						for (int i = 0; i < size; i++) {
//							chatClient cc = list.get(i);
//						}

						// ���� for�� - ���� ����
					    // ���� ������ ����������鿡�� ���� ���Դٰ� �˸�
						multicast((ChatConstance.SC_CONNECT + "|" + name));
						list.add(this); // ������ ���� ����
						for (ChatClient cc : list) { // �̹����� cc���ƴ� this //������ ������ ��ȭ���� ������
							unicast((ChatConstance.SC_CONNECT + "|" + cc.name));
						}
					}break;
					case ChatConstance.CS_ALL: {
//							200|�ȳ��ϼ���
						String tmp = st.nextToken(); // �ȳ��ϼ���
					 // ���� ������ ����������鿡�� ���� ���Դٰ� �˸�
							multicast((ChatConstance.SC_MESSAGE + "|[" + name + "] " + tmp ));
						
					}break;
					case ChatConstance.CS_TO: {
//						250|ȫ�浿|�ȳ�
						String to = st.nextToken(); //ȫ�浿
						String tmp = st.nextToken(); //�ȳ�?
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_MESSAGE + "|��" + name + "��" + tmp);
								break;
							}
						}
					}break;
					case ChatConstance.CS_PAPER: {
//						300|�����|�޼���
						String to = st.nextToken(); //�����
						String tmp = st.nextToken(); //�޼���
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
//								300|���������ȭ��|�޼���
								cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);
								break;
							}
						}
						
					}break;
					case ChatConstance.CS_RENAME: {
//						��ȭ���� : 400|���ο� ��ȭ��
						String newid = st.nextToken(); //������ ��ȭ��
//						��ȭ����:  400|��������ȭ��|�����Ҵ�ȭ��
						multicast(ChatConstance.SC_RENAME + "|" + name + "|" + newid);
						name = newid; //�̰Ÿ� �ؾ� ��ȭ���� �����
					}break;
					
					case ChatConstance.CS_DISCONNECT: {
//						900|
						multicast(ChatConstance.SC_DISCONNECT + "|" + name);//���� ������ ��� ������� ������
						list.remove(this);//����Ʈ���� ���� ����
						flag = false; //����ġ���̽����� �극��ũ�� ���ϴ� �÷��׻��
						in.close();//��װ� null�̾����� ������� �������� �������Ŷ� if�� �ȵ����� �ݱ���
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
		private void multicast(String msg) { // ��������� �޼�����������
			for (ChatClient cc : list) {
				cc.unicast(msg);
			}
			
		}

		private void unicast(String msg) { // Ư��������� �޽���������
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
//		t.start(); //������ ����

		// ���ٷ� �ٲٱ�
		new Thread(new ChatServer()).start(); // start�� �ҰŶ� �͸����� ��ü ����

	}

}
