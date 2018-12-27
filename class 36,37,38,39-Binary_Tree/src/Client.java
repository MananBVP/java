import java.nio.channels.Pipe;
import java.util.LinkedList;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		int[] arr1 = { 50, 25, 12, 10, -1, 20, -1, -1, -1, 75, 62, 60, -1, -1, 87, -1, -1, -1 };
		Binary_Trees bt = new Binary_Trees(arr);
//		Binary_Trees bt1 = new Binary_Trees(arr1);
//		bt.display();
//		System.out.println("------------------");
//		bt1.display();
//		System.out.println("------------------");
//		System.out.println(bt.size2());
//		System.out.println(bt.max());
//		System.out.println(bt.min());
//		System.out.println(bt.height());
//		System.out.println(bt.find(40));
//		bt1.printSingleChild();
//		bt1.removeLeaf();
//		bt1.display();
//		System.out.println(bt.rootToNodePath(75));

//		int[] preO = { 50, 25, 12, 37, 75, 62, 87 };
//		int[] inO = { 12, 25, 37, 50, 62, 75, 87 };
//		int[] postO = { 12, 37, 25, 62, 87, 75, 50 };
//		Binary_Trees bt3 = new Binary_Trees(preO , inO);
//		Binary_Trees bt4 = new Binary_Trees(postO, inO);
//		bt3.display();
//		bt4.display();
//		printBinary(15);
//		bt4.preOIterative();
//		bt4.postOIterative();
//		bt4.inOIterative();
//		System.out.println(bt.isBalanced());
//		System.out.println(bt4.isBalanced());
//		System.out.println(bt.IsBalanced());
		System.out.println(bt.isBST());
	}

	private static class Pair {
		int data;
		String bin;

		public Pair(int data, String bin) {
			this.data = data;
			this.bin = bin;
		}
	}

	public static void printBinary(int n) {
		LinkedList<Pair> queue = new LinkedList<>();
		Pair rmp = new Pair(1, "1");
		queue.addLast(rmp);

		while (queue.size() > 0) {
			Pair rm = queue.removeFirst();
			System.out.println(rm.data + " = " + rm.bin);
			Pair lfp = new Pair(rm.data * 2, rm.bin + "0");
			Pair rgp = new Pair(rm.data * 2 + 1, rm.bin + "1");

			if (lfp.data <= n) {
				queue.addLast(lfp);
			}

			if (rgp.data <= n) {
				queue.addLast(rgp);
			}

		}

	}
}
