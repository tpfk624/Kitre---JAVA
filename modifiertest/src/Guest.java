public class Guest {
	
	int cnt; //Class변수
	String name; //instance 변수
	
	public Guest(String name){
		this.name = name;
	}

	public int visit(){
		cnt++;
		return cnt;
	}
}
