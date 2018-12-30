
public class Client {

	public static void main(String[] args) {
		int[] sa= {12 , 25 , 37 , 50 , 62 , 75 , 87};
		AVL at = new AVL(sa);
//		at.display();
		
		at.add(10);
		at.add(5);
		at.add(11);
		at.display();
	}

}
