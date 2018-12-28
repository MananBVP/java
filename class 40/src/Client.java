
public class Client {

	public static void main(String[] args) {
		int[] sa= {12 , 25 , 37 , 50 , 62 , 75 , 87};
		BST bt = new BST(sa);
//		bt.display();
//		System.out.println(bt.max());
//		System.out.println(bt.min());
//		System.out.println(bt.find(12));
//		System.out.println(bt.find(11));
		int[] sa1= {12 , 25 , 30 , 37 , 40 , 50 , 60 , 62 , 70 ,  75 , 87};
		BST bt1 = new BST(sa1);
//		bt1.display();
//		System.out.println("---------------");
//		bt1.printInRange(26, 80);
		int[] sa2= {10 , 20 , 30 , 50 , 60 , 70 , 80};
		BST bst2 = new BST(sa2);
		bst2.display();
//		System.out.println("---------------");
//		bst2.replaceWithSumOfLargerNodes();
//		bst2.add(40);
//		bst2.display();
//		System.out.println("---------------");
//		bst2.remove(20);
//		bst2.display();
//		bt.add(30);
//		bt.add(40);
//		bt.add(60);
//		bt.add(70);
//		System.out.println("----------------");
//		bt.display();
//		System.out.println("-----------------");
//		bt.remove(30);
//		bt.remove(37);
//		bt.remove(75);
//		bt.display();
		System.out.println(bt.LCA(12, 87));
		
	}

}
