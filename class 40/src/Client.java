
public class Client {

	public static void main(String[] args) {
		int[] sa= {12 , 25 , 37 , 50 , 62 , 75 , 87};
		BST bt = new BST(sa);
		bt.display();
		System.out.println(bt.max());
		System.out.println(bt.min());

	}

}
