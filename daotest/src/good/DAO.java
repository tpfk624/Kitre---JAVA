package good;

public class DAO {
	
	//static�ʱ�ȭ
	static {
		try {
			Class.forName("oracle.jdbd.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
