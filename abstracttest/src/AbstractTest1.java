import java.util.*;

public class AbstractTest1 {
	public static void main(String[] args) {

		//1. 하위클래스 참조
		//Calendar cal = new GregorianCalendar(); //abstract라 객체생성불가능, 하위클래스 참조

		//2. 자신의 객체를 return하는 static method (getInstance())
		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;  //0부터 시작해서 1월이 0
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println( y + "년 " +  m + "월 " + d + "일 " + h + "시 " + mi + "분 " +  s + "초");
		 
		
	}
}
