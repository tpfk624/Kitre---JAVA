package test_dtodao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTest {
public static void main(String[] args){
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "kitri";
	String password = "kitri";
	try {
		Class.forName(driver);
		System.out.println("jdbc driver �ε� ����");
		DriverManager.getConnection(url, user, password);
		System.out.println("����Ŭ ���� ����");
	} catch (ClassNotFoundException e) {
		System.out.println("jdbc driver �ε� ����");
	} catch (SQLException e) {
		System.out.println("����Ŭ ���� ����");
	}
}
}