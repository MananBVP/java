
public class Client {

	public static void main(String[] args) {
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		int[] arr1 = {50, 25, 12, 10, -1, 20, -1, -1, -1, 75, 62, 
				 60, -1, -1,  87, -1, -1 , -1};
		Binary_Trees bt = new Binary_Trees(arr);
		Binary_Trees bt1 = new Binary_Trees(arr1);
		bt.display();
		System.out.println("------------------");
		bt1.display();
		System.out.println("------------------");
//		System.out.println(bt.size2());
//		System.out.println(bt.max());
//		System.out.println(bt.min());
//		System.out.println(bt.height());
//		System.out.println(bt.find(40));
//		bt1.printSingleChild();
		bt1.removeLeaf();
		bt1.display();
	}

}
