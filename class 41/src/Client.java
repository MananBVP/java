
public class Client {

	public static void main(String[] args) {
		int[] sa= {12 , 25 , 37 , 50 , 62 , 75 , 87};
		AVL at = new AVL(sa);
//		at.display();
		
//		at.add(10);
//		at.add(5);
//		at.add(11);
//		at.display();
		
		at.add(10);
		at.add(20);
		at.add(30);
		at.add(40);
		at.add(60);
		at.add(70);
		at.add(80);
		at.add(90);
		at.display();
		System.out.println("-------------------");
		at.remove(30);
		at.remove(40);
		at.remove(37);
		at.remove(10);
		at.display();
		
	}

}
