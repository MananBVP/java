
public class Client {

	public static void main(String[] args) {
		int[] sa= {12 , 25 , 37 , 50 , 62 , 75 , 87};
		BST bt = new BST(sa);
		bt.display();
		System.out.println(bt.max());
		System.out.println(bt.min());
		System.out.println(bt.find(12));
		System.out.println(bt.find(11));

	}

}
