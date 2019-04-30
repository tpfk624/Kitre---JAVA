package com.kitri.chat.client;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kitri.chat.util.ChatConstance;
//import com.sun.glass.events.WindowEvent;

public class Login extends JFrame implements ActionListener, Runnable, ListSelectionListener {
//	private static final WindowListener WindowEvent = null;
	// 지금 로그인하는 사람의 창이다

	Socket socket;
	String myid;
	BufferedReader in;
	OutputStream out;

	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf;
	JButton cancel;
	JButton ok;

	Chat chat;
	Paper paper;
	Rename rename;

	public Login() {
		super("Login!!");
		initGUI();

		chat = new Chat();
		paper = new Paper();
		rename = new Rename();

		// 일반적으로는 setvisible 밑에서 이벤트 등록하지만
		// 여기서는

		// Login창 event등록
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);

		// Chat창 event 등록
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);

		chat.list.addListSelectionListener(this);

		chat.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closeProcess();
			}
		});

		// paper창 event 등록
		paper.ok.addActionListener(this);
		paper.cancel.addActionListener(this);
		paper.answer.addActionListener(this);

		// Rename창 event 등록
		rename.ok.addActionListener(this);
		rename.cancel.addActionListener(this);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244, 243, 242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField();
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237, 236, 233));
				ok.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237, 236, 233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == nameTf || ob == ok) {
			connetProcess();
		} else if (ob == cancel) {
			System.exit(0);
		} else if (ob == chat.globalsend) {
			globalsendProcess();
		} else if (ob == chat.whomsend) {
			whomsendProcess();
		} else if (ob == chat.paper) {
			paperProcess();
		} else if (ob == chat.rename) {
			viewRename();
		} else if (ob == chat.exit) {
			closeProcess();	
		} else if (ob == paper.ok) { // 쪽지보내기
			paperSendProcess();
			paper.setVisible(false);
			paperReset();
		} else if (ob == paper.answer) {
			answerProcess();
		} else if (ob == paper.cancel) {
			paper.setVisible(false);
			paperReset();
		} else if (ob == rename.ok) { // 이름바꾸기
			renameProcess();
		} else if (ob == rename.cancel) {
			closeRename();
			
		}
	}

	
	
	private void renameProcess() {
		String newid = rename.newname.getText().trim();
		if (newid.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대화명을 입력하세요.", "대화명오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
//		대화명변경 400|번경할 대화명
		sendMessage(ChatConstance.CS_RENAME + "|" + newid);
		myid = newid;
		closeRename();
//		viewMessage("변경할 대화명이 제대로 보내졌습니다.");
	}
	
	private void closeRename() {
		rename.oldname.setText("");
		rename.setVisible(false);
		
	}

	private void viewRename() {
		rename.oldname.setText(myid);
		rename.setVisible(true);
	}

	
	private void answerProcess() {
		paper.to.setText(paper.from.getText());
		paper.from.setText(myid);// 위치바꾸기
		paper.letter.append("\n\n----------------------[원글]\n\n");
//		paper.letter.setText("");
		paper.card.show(paper.cardp, "ok");	
	}


	public void paperReset() { // 초기화시키기
		paper.from.setText("");
		paper.to.setText("");
		paper.letter.setText("");
		paper.card.show(paper.cardp, "ok");

	}

	private void paperSendProcess() {
//		300| 대상자 |메세지
		sendMessage(ChatConstance.CS_PAPER + "|" + paper.to.getText() + "|" + paper.letter.getText().replace("\n", "/n/"));
		//\n전까지 인식해 한줄만 보내지니까 \n을 다른 문자로 치환해서 보내기
		viewMessage("쪽지가 성공적으로 보내졌습니다.");

	}

	private void paperProcess() {
//		String selName = chat.list.getSelectedValue();

		String name = chat.whom.getText();
//		유효성검사
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요.", "대상자오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (name.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 쪽지를?.", "대상자오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		paper.to.setText(name);// to에 이름받아오기
		paper.from.setText(myid); // from에 내 이름 넣어주기
		paper.setVisible(true);// 쪽지창띄우기

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}

	private void closeProcess() {// 서버에게 나간다고 알려주기
		sendMessage(ChatConstance.CS_DISCONNECT + "|");
	}

//	1. 대상자 메세지get(유효성검사, 대상자, 자신, 메시지)
//	2. server로 메세지전송
	private void whomsendProcess() { 
//		1.
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if (msg.isEmpty()) {
			return;
		}
//		2
		String to = chat.whom.getText();
		if (to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요.", "대상자오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 귓속말을?.", "대상자오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
//		3.
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("★" + to + "★" + msg); // 색깔o별 = 내가 보낸거 //색깔x =내가 받은 거

	}

//	 1. 메세지get(유효성검사)
//	2. server로 메세지전송
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if (msg.isEmpty()) {
			return;
		} // 1번끝

		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

	// 1. ip, 대화명 get(유효성검사(대화명 3자이상))
//	2. 1의 ip를 이용해서 Socket생성
//	3. IO(BufferReader, OutputStream) 생성
//	4. Login창 닫고 chat창 열기
//	5. server로 메세지전송(안효인)
//	6. Thread 실행
	private void connetProcess() {
		String ip = ipTf.getText().trim(); // ip얻어오기
		myid = nameTf.getText().trim();
		if (myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "대화명은 3자 이상입니다", "대화명오류", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			socket = new Socket(ip, ChatConstance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 3. IO(BufferReader, OutputStream)
																					// 생성
			out = socket.getOutputStream();
			this.setVisible(false); // 4.Login창 닫고 chat창 열기
			chat.setVisible(true);
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid); // string을 byte로 쪼개기//엔터기준으로 입력받으니 엔터를
																// 반드시 보내줘야함
			new Thread(this).start();// 쓰레드시작하기
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();// string을 byte로 쪼개기//엔터기준으로 입력받으니 엔터를
			// 반드시 보내줘야함
		}
	}

	// 이제는 각각의 창 //화면에 뿌려지는 각자의 창 //내창일수도 여러분창일수도 있다.
	@Override
	public void run() {// 클라이언트 메세지처리
		boolean flag = true;
		while (flag) { // 무한루프
			try {
				String msg = in.readLine(); // 한줄씩 받아옴 소켓에서
				System.out.println("서버가 보낸 메세지: " + msg);// protocol|메세지형식.....
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case ChatConstance.SC_CONNECT: {
//					100 | 접속자대화명
					String tmp = st.nextToken();
					viewMessage("[알림]" + tmp + "님이 접속하였습니다. ");

					// jlist는 add가 안됨
					chat.listData.add(tmp);
					chat.list.setListData(chat.listData);// vector를 지정함
				}
					break;
				case ChatConstance.SC_MESSAGE: {
//						200|[안효인]|안녕하세요
//						200 | ☆안효인☆ 안녕하세요
					String tmp = st.nextToken();// [안효인]안녕하세요....
					viewMessage(tmp);

				}
					break;
				case ChatConstance.SC_PAPER: { // 쪽지
//					쪽지보내기 300|보낸사람 대화명|메세지
					String from = st.nextToken();// 보낸사람
					String tmp = st.nextToken();// 메세지
					paper.from.setText(from);
					paper.to.setText(myid);
					paper.letter.setText(tmp.replace("/n/", "\n")); //한줄만 보내지니까 \n을 다른 문자로 치환한걸 다시 \n으로 받기
					paper.card.show(paper.cardp, "answer");// 우리가 원하는 카드레이아웃창띄우기

					paper.setVisible(true); // 자기 자신의 창이니까 this 받는 사람의 창임
				}
					break;
				case ChatConstance.SC_RENAME: {
//					대화명변경: 400|변경전대화명|변경할대화명
					String oldname = st.nextToken();// 보낸사람
					String newname = st.nextToken();// 메세지
					viewMessage("[알림]" + oldname + "님이 대화명을" + newname + "으로 변경하였습니다");
					chat.listData.set(chat.listData.indexOf(oldname), newname);//올드네임을 뉴네임으로 바꿔라
					chat.list.setListData(chat.listData);// 리스트에 이 벡터를 적용시킴
					
				
				}
					break;
				case ChatConstance.SC_DISCONNECT: {
//					900|나가는 사람
					String tmp = st.nextToken(); // 나가는사람
					if (!tmp.equals(myid)) {
						viewMessage("[알림]" + tmp + "님이 접속을 종료하였습니다");
						chat.listData.remove(tmp);// 지우고
						chat.list.setListData(chat.listData);// 리스트에 이 벡터를 적용시킴
					} else {
						flag = false;
						in.close();
						out.close();
						socket.close();
						System.exit(0);// 원래는 강제종료보다는 자연종료가 좋긴 하다.
//						chat.setVisible(false); //프로그램이 안보이게되고 안보이면서 종료가 된다?
					}
				}
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;//강제종료하면 에러계속나서 한번만 나게 멈춤
			}
		}
	}

	private void viewMessage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());// 스크롤바 밑으로 내리기
	}

}
