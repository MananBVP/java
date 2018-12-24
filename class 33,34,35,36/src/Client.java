
public class Client {

	public static void main(String[] args) {
		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Generic_trees gt=new Generic_trees(arr);
		Generic_trees gt2=new Generic_trees(arr);
		gt.display();
//		System.out.println(gt.size2());
//		System.out.println(gt.max());
//		System.out.println(gt.height());
//		System.out.println(gt.find(10));
//		System.out.println(gt.find(105));
//		System.out.println(gt.nodeToRootPath(110));
		System.out.println("------------------");
//		gt.removeCurrentLeaves();
//		gt.display();
//		gt.mirror();
//		gt.display();
//		gt.linearize();
//		gt.display();
//		gt.linearize_2();
//		gt.display();
//		System.out.println(gt.areSimilarShape(gt, gt2));
//		gt.multiSolver();
//		gt.multiSolver2(5);
//		gt.multiSolver3(90);
//		gt.level_Order();
//		gt.level_OrderLineWise();
//		gt.level_OrderLineWise2();
		gt.level_OrderLineWise3();
		
	}

}
