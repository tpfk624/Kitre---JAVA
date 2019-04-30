import java.util.*;

public class myAbstractTest1 {

	public static void main(String[] args) {
		//Ä¶¸°´õ°´Ã¼ ¹Þ¾Æ¿À±â
		//Calendar cal = new GregorianCalendar();
		
		Calendar get;
		Calendar cal = Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DATE);
		System.out.println(y + m + d);
		
	}

}
