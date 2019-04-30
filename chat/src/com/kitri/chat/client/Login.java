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
	// ���� �α����ϴ� ����� â�̴�

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

		// �Ϲ������δ� setvisible �ؿ��� �̺�Ʈ ���������
		// ���⼭��

		// Loginâ event���
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);

		// Chatâ event ���
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

		// paperâ event ���
		paper.ok.addActionListener(this);
		paper.cancel.addActionListener(this);
		paper.answer.addActionListener(this);

		// Renameâ event ���
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
		} else if (ob == paper.ok) { // ����������
			paperSendProcess();
			paper.setVisible(false);
			paperReset();
		} else if (ob == paper.answer) {
			answerProcess();
		} else if (ob == paper.cancel) {
			paper.setVisible(false);
			paperReset();
		} else if (ob == rename.ok) { // �̸��ٲٱ�
			renameProcess();
		} else if (ob == rename.cancel) {
			closeRename();
			
		}
	}

	
	
	private void renameProcess() {
		String newid = rename.newname.getText().trim();
		if (newid.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "��ȭ���� �Է��ϼ���.", "��ȭ�����", JOptionPane.ERROR_MESSAGE);
			return;
		}
//		��ȭ���� 400|������ ��ȭ��
		sendMessage(ChatConstance.CS_RENAME + "|" + newid);
		myid = newid;
		closeRename();
//		viewMessage("������ ��ȭ���� ����� ���������ϴ�.");
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
		paper.from.setText(myid);// ��ġ�ٲٱ�
		paper.letter.append("\n\n----------------------[����]\n\n");
//		paper.letter.setText("");
		paper.card.show(paper.cardp, "ok");	
	}


	public void paperReset() { // �ʱ�ȭ��Ű��
		paper.from.setText("");
		paper.to.setText("");
		paper.letter.setText("");
		paper.card.show(paper.cardp, "ok");

	}

	private void paperSendProcess() {
//		300| ����� |�޼���
		sendMessage(ChatConstance.CS_PAPER + "|" + paper.to.getText() + "|" + paper.letter.getText().replace("\n", "/n/"));
		//\n������ �ν��� ���ٸ� �������ϱ� \n�� �ٸ� ���ڷ� ġȯ�ؼ� ������
		viewMessage("������ ���������� ���������ϴ�.");

	}

	private void paperProcess() {
//		String selName = chat.list.getSelectedValue();

		String name = chat.whom.getText();
//		��ȿ���˻�
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���.", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (name.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "�ڽſ��� ������?.", "����ڿ���", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		paper.to.setText(name);// to�� �̸��޾ƿ���
		paper.from.setText(myid); // from�� �� �̸� �־��ֱ�
		paper.setVisible(true);// ����â����

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}

	private void closeProcess() {// �������� �����ٰ� �˷��ֱ�
		sendMessage(ChatConstance.CS_DISCONNECT + "|");
	}

//	1. ����� �޼���get(��ȿ���˻�, �����, �ڽ�, �޽���)
//	2. server�� �޼�������
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
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���.", "����ڿ���", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "�ڽſ��� �ӼӸ���?.", "����ڿ���", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
//		3.
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("��" + to + "��" + msg); // ����o�� = ���� ������ //����x =���� ���� ��

	}

//	 1. �޼���get(��ȿ���˻�)
//	2. server�� �޼�������
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if (msg.isEmpty()) {
			return;
		} // 1����

		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

	// 1. ip, ��ȭ�� get(��ȿ���˻�(��ȭ�� 3���̻�))
//	2. 1�� ip�� �̿��ؼ� Socket����
//	3. IO(BufferReader, OutputStream) ����
//	4. Loginâ �ݰ� chatâ ����
//	5. server�� �޼�������(��ȿ��)
//	6. Thread ����
	private void connetProcess() {
		String ip = ipTf.getText().trim(); // ip������
		myid = nameTf.getText().trim();
		if (myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "��ȭ���� 3�� �̻��Դϴ�", "��ȭ�����", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			socket = new Socket(ip, ChatConstance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// 3. IO(BufferReader, OutputStream)
																					// ����
			out = socket.getOutputStream();
			this.setVisible(false); // 4.Loginâ �ݰ� chatâ ����
			chat.setVisible(true);
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid); // string�� byte�� �ɰ���//���ͱ������� �Է¹����� ���͸�
																// �ݵ�� ���������
			new Thread(this).start();// ����������ϱ�
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
			e.printStackTrace();// string�� byte�� �ɰ���//���ͱ������� �Է¹����� ���͸�
			// �ݵ�� ���������
		}
	}

	// ������ ������ â //ȭ�鿡 �ѷ����� ������ â //��â�ϼ��� ������â�ϼ��� �ִ�.
	@Override
	public void run() {// Ŭ���̾�Ʈ �޼���ó��
		boolean flag = true;
		while (flag) { // ���ѷ���
			try {
				String msg = in.readLine(); // ���پ� �޾ƿ� ���Ͽ���
				System.out.println("������ ���� �޼���: " + msg);// protocol|�޼�������.....
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case ChatConstance.SC_CONNECT: {
//					100 | �����ڴ�ȭ��
					String tmp = st.nextToken();
					viewMessage("[�˸�]" + tmp + "���� �����Ͽ����ϴ�. ");

					// jlist�� add�� �ȵ�
					chat.listData.add(tmp);
					chat.list.setListData(chat.listData);// vector�� ������
				}
					break;
				case ChatConstance.SC_MESSAGE: {
//						200|[��ȿ��]|�ȳ��ϼ���
//						200 | �پ�ȿ�Ρ� �ȳ��ϼ���
					String tmp = st.nextToken();// [��ȿ��]�ȳ��ϼ���....
					viewMessage(tmp);

				}
					break;
				case ChatConstance.SC_PAPER: { // ����
//					���������� 300|������� ��ȭ��|�޼���
					String from = st.nextToken();// �������
					String tmp = st.nextToken();// �޼���
					paper.from.setText(from);
					paper.to.setText(myid);
					paper.letter.setText(tmp.replace("/n/", "\n")); //���ٸ� �������ϱ� \n�� �ٸ� ���ڷ� ġȯ�Ѱ� �ٽ� \n���� �ޱ�
					paper.card.show(paper.cardp, "answer");// �츮�� ���ϴ� ī�巹�̾ƿ�â����

					paper.setVisible(true); // �ڱ� �ڽ��� â�̴ϱ� this �޴� ����� â��
				}
					break;
				case ChatConstance.SC_RENAME: {
//					��ȭ����: 400|��������ȭ��|�����Ҵ�ȭ��
					String oldname = st.nextToken();// �������
					String newname = st.nextToken();// �޼���
					viewMessage("[�˸�]" + oldname + "���� ��ȭ����" + newname + "���� �����Ͽ����ϴ�");
					chat.listData.set(chat.listData.indexOf(oldname), newname);//�õ������ ���������� �ٲ��
					chat.list.setListData(chat.listData);// ����Ʈ�� �� ���͸� �����Ŵ
					
				
				}
					break;
				case ChatConstance.SC_DISCONNECT: {
//					900|������ ���
					String tmp = st.nextToken(); // �����»��
					if (!tmp.equals(myid)) {
						viewMessage("[�˸�]" + tmp + "���� ������ �����Ͽ����ϴ�");
						chat.listData.remove(tmp);// �����
						chat.list.setListData(chat.listData);// ����Ʈ�� �� ���͸� �����Ŵ
					} else {
						flag = false;
						in.close();
						out.close();
						socket.close();
						System.exit(0);// ������ �������Ẹ�ٴ� �ڿ����ᰡ ���� �ϴ�.
//						chat.setVisible(false); //���α׷��� �Ⱥ��̰Եǰ� �Ⱥ��̸鼭 ���ᰡ �ȴ�?
					}
				}
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;//���������ϸ� ������ӳ��� �ѹ��� ���� ����
			}
		}
	}

	private void viewMessage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());// ��ũ�ѹ� ������ ������
	}

}
