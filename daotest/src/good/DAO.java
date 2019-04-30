package good;

public class DAO {
	
	//static√ ±‚»≠
	static {
		try {
			Class.forName("oracle.jdbd.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
