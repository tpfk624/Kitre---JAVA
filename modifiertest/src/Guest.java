public class Guest {
	
	int cnt; //Class����
	String name; //instance ����
	
	public Guest(String name){
		this.name = name;
	}

	public int visit(){
		cnt++;
		return cnt;
	}
}
