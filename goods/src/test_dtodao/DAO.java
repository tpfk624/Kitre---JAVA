package test_dtodao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	// �����ͺ��̽� ������ ���õ� �ڵ�

	// �������
//	1)Ŭ���� �ε� (���α׷� ��ü���� 1���� �ϸ� OK) - Static �ʱ�ȭ
//	2)DB���� - Connection��ü�� �̿�(�޼ҵ带 ����)
//	����Ǹ� true, �ȵǸ� false 
//	Connection���� = DriverManager.getConnection(��ġ,���̵�,���)�� �̿�
//	*���۾��� �ؾ� DB������ �ȵ��� �� �ٸ� �۾��� ���� �� ����

//	3)DB��� - Statement, PreparedStatement, CallableStatement ��ü (SQL�� ����)
//	ResultSet - Select ���� ��� ��� 
//	
//	4)�ڿ��� ���� - 3) ��ü 3�� close();

	// ����,���,������ ������ü���� ���� ���ɼ��� ���� => ���������� ����� ���� ����.
	private Connection con;
	private Statement stmtI;
	private Statement stmtE;
	private ResultSet rs;
	private ResultSet rsE;
	// �� ������ ������ ���� ���������� �����Ѵ�.
	// why? Connection ������ �����ؾ� �װ��� ������ Statement ��ü�� ��������
	// Statement��ü�� Select ������ �����ϴµ� �����ؾ� ResultSet��ü�� ���������.
	// =>����, Connection��ü�� ������ ������ ���� �� �۾��� �����ؼ� �����ϴ� ���� ����.

	static {// static �ʱ�ȭ �۾�
		// �� ������� Ŭ������ �޸𸮿� �ε�� �� �� �ѹ��� �����.

		try {// ����Ŭ ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ŭ���� �ε� ���� :" + e.getMessage());
		}
	}

	private DAO() {// SingletonŬ������ ����� ���� ����--�����ڸ� private�� �����Ѵ�.

	}

	private static DAO obj;// ������ ��ü�� �ּҷ� ������ ���� ����

	public static DAO sharedInstance() {// ���� ������ static������ ��ü�� �������ִ� �޼���
		if (obj == null) {
			obj = new DAO();
		}
		return obj;
	}

	// �����ͺ��̽� ������ �������ִ� �޼ҵ�
	private boolean connect() {
		boolean result = false;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("������� : " + e.getMessage());
		}
		return result;
	}

//�����ͺ��̽� ������ �����ϴ� �޼ҵ�
	private void close() {
		if (rs != null)
			try {
				rs.close();
				if (stmtI != null)
					stmtI.close();
				if (stmtE !=null)
					stmtE.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("���� ����:" + e.getMessage());
			}

	}

	// ��� ���̺��� ��� �����͸� �о List<Good> Ÿ�Կ� �����ؼ� �����ϴ� �޼ҵ�
	// SQL �̿�
	// Good�� DTOŬ������ Good
	public List<Good> getList() {
		// �����͸� ������ ���� ����
		List<Good> list = null;

		// ������ SQL��
		String sql = "SELECT * FROM goods";

		// �����ͺ��̽��� ������ �Ǿ��� ���� Select�� ����
		if (connect()) {
			// ���Ἲ����
			try {
				// connection��ü�� ����� Statement��ü�� �����Ͽ� statement������ ����
				stmtI = con.createStatement();
				if ((stmtI != null)) {// sql������ �޾ƿͼ� null�� �ƴϴ�
					rs = stmtI.executeQuery(sql);// sql��� ����
					
					// �����͸� ������ ����Ʈ ����
					list = new ArrayList<Good>();

					// �����͸� �о list�� ����
					while (rs.next()) {
						Good goods = new Good();
						// DTOŬ������ ������ ����(Set�޼��� �̿�)
						// select����� �÷������� �о����(get����Ÿ��(�÷���)�޼ҵ� �̿�)

						goods.setCode(rs.getString("code"));
						goods.setName(rs.getString("name"));
						goods.setManufacture(rs.getString("manufacture"));
						goods.setPrice(rs.getInt("price"));
						goods.setMakingdate(rs.getDate("makingdate"));
						list.add(goods);
						
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�����ͺ��̽� ���ῡ ����");
			System.exit(0);
		}
		return list;
	}

	
//	//�����ϴ� �޼���
//	public boolean EditGood(Good good) {
//		boolean result = false;
//
//		if (this.connect()) {
//			String sql = "UPDATE goods SET NAME= ?, MANUFACTURE = ?, PRICE =?  WHERE CODE = cast(? as char(5))";//����ȯ
//			try {
//				PreparedStatement pstmt = con.prepareStatement(sql);// connection���� ������ sql�� ������ pstmt��ü ����
//				// ���ε� �۾� : VALUES�� ?�� ���� ����� �ϴ� ���� ������ ���� �Է�
//				// HOW TO? set�ڷ���(�÷�, �� ������);
//				//���⼭ ���ڴ� ?�� ����
//				pstmt.setString(1, good.getName());
//				pstmt.setString(2, good.getManufacture());
//				pstmt.setInt(3, good.getPrice());
//				pstmt.setString(4, good.getCode());
//
//				int r = pstmt.executeUpdate();
//
//				if (r > 0) {// ������Ʈ�� ����Ǹ�
//					result = true;
//				}
//				// �����ͺ��̽� ���� ��ü ����
//				pstmt.close();
//				this.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println(e.getMessage());// ���ܰ� �߻��� ���� ������ ���ڿ��� ���·� ��ȯ
//				// ���� Ŭ������ ThrowableŬ������ ���, ���⿡ getMessage�� ���� �Ǿ� ����
//			}
//		} else {
//			System.out.println("�����ͺ��̽� �������");
//			System.exit(0);
//		}
//		return result;
//	}
	
	
	
	// (DB)Goods ���̺� �����͸� �����ϴ� �޼���
	public boolean InsertGood(Good good) {
		boolean result = false;

		if (this.connect()) {
			String sql = "INSERT INTO goods Values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);// connection���� ������ sql�� ������ pstmt��ü ����
				// ���ε� �۾� : VALUES�� ?�� ���� ����� �ϴ� ���� ������ ���� �Է�
				// HOW TO? set�ڷ���(�÷�, �� ������);
				pstmt.setString(1, good.getCode());// �ε����� DB�����̹Ƿ� 1���� ����
				pstmt.setString(2, good.getName());
				pstmt.setString(3, good.getManufacture());
				pstmt.setInt(4, good.getPrice());
				pstmt.setDate(5, good.getMakingdate());

				int r = pstmt.executeUpdate();

				if (r > 0) {// ������Ʈ�� ����Ǹ�
					result = true;
				}
				// �����ͺ��̽� ���� ��ü ����
				pstmt.close();
				this.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());// ���ܰ� �߻��� ���� ������ ���ڿ��� ���·� ��ȯ
				// ���� Ŭ������ ThrowableŬ������ ���, ���⿡ getMessage�� ���� �Ǿ� ����
			}
		} else {
			System.out.println("�����ͺ��̽� �������");
			System.exit(0);
		}
		return result;
	}
}
