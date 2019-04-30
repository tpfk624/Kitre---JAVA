public class FinalMethodExt extends FinalMethod {
	
	@Override
	public void a() { //final method는 Override 불가능
		x = 30;
	}
}
