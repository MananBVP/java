
public class Client {

	public static void main(String[] args) {
		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Generic_trees gt=new Generic_trees(arr);
		gt.display();
		System.out.println(gt.size2());
		System.out.println(gt.max());
	}

}
