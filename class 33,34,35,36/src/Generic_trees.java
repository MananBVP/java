import java.text.spi.CollatorProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Generic_trees {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public Generic_trees(int[] arr) {
		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];
				if (stack.size() > 0) {
					stack.peek().children.add(node);
				} else {
					root = node;
				}
				stack.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String s = node.data + " -> ";
		for (Node child : node.children) {
			s += child.data + ",";
		}
		s += ".";
		System.out.println(s);

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int s = 0;
		for (Node child : node.children) {
			s += size2(child);
		}
		s++; // for the node itself
		return s;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
//		if(node.children.size() == 0) {
//			return node.data;
//		}
		int m = node.data;
//		int m = Integer.MIN_VALUE;

		for (Node child : node.children) {
			int a = max(child);
			m = Math.max(a, m);
		}
		return m;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int m = 0;

		for (Node child : node.children) {
			int a = height(child);
			m = Math.max(a, m);
		}
		return m + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			if (find(child, data) == true) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {
		ArrayList<Integer> a = new ArrayList<>();
		if (node.data == data) {
			a.add(node.data);
			return a;
		}
		for (Node child : node.children) {
			a = nodeToRootPath(child, data);
			if (a.size() > 0) {
				a.add(node.data);
				return a;
			}
		}
		return a;
	}

	public void removeCurrentLeaves() {
		removeCurrentLeaves(root);
	}

	private void removeCurrentLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() > 0) {
				removeCurrentLeaves(child);
			} else {
				node.children.remove(child);
			}
		}
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		Collections.reverse(node.children);

		for (Node child : node.children) {
			mirror(child);
		}

		/*
		 * int left=0; int right=node.children.size() -1; while(left<right) { Node
		 * leftnode =node .children.get(left); Node rightnode =node
		 * .children.get(right); node.children.set(left, rightnode);
		 * node.children.set(right, leftnode); left++; right--; }
		 */
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		for (int i = node.children.size() - 1; i > 0; i--) {
			Node lr = node.children.remove(i);
			Node sl = node.children.get(i - 1);
			Node tail = getTail(sl);
			tail.children.add(lr);
		}
	}

	private Node getTail(Node node) {
		while (node.children.size() != 0) {
			node = node.children.get(0);
		}
		return node;
	}

	public void linearize_2() {
		linearize(root);
	}

	// linearizes and returns tail
	private Node linearize_2(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node lnodeTail = linearize_2(node.children.get(node.children.size() - 1));
		while (node.children.size() > 1) {
			Node lr = node.children.remove(node.children.size() - 1);
			Node sl = node.children.get(node.children.size() - 1);
			Node sltail = linearize_2(sl);
			sltail.children.add(lr);
		}
		return lnodeTail;
	}

	public static boolean areSimilarShape(Generic_trees gt1, Generic_trees gt2) {
		return areSimilarShape(gt1.root, gt2.root);
	}

	private static boolean areSimilarShape(Node n1, Node n2) {
		if (n1.children.size() == n2.children.size()) {
			for (int i = 0; i < n1.children.size() - 1; i++) {
				boolean a = areSimilarShape(n1.children.get(i), n2.children.get(i));
				if (a == false) {
					return false;
				}
				return a;
			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean areMirrorImages(Generic_trees gt1, Generic_trees gt2) {
		return areMirrorImages(gt1.root, gt2.root);
	}

	private static boolean areMirrorImages(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		int left = 0;
		int right = n1.children.size() - 1;
		while (left < n1.children.size()) {
			Node lc = n1.children.get(left);
			Node rc = n1.children.get(right);

			boolean aremi = areMirrorImages(lc, rc);
			if (aremi == false) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}

	// is foldable
	public boolean isSymmetric() {
		return Generic_trees.areMirrorImages(this, this);
	}

	// size,min,max,height
	public void multiSolver() {
		msSize = 0;
		msMin = Integer.MAX_VALUE;
		msMax = Integer.MIN_VALUE;
		msHeight = 0;
		multiSolver(root, 0);

		System.out.println("Size = " + msSize);
		System.out.println("Max = " + msMax);
		System.out.println("Min = " + msMin);
		System.out.println("Height = " + msHeight);
	}

	private int msSize = 0;
	private int msMin = Integer.MAX_VALUE;
	private int msMax = Integer.MIN_VALUE;
	private int msHeight = 0;

	private void multiSolver(Node node, int depth) {
		msSize++;
		msMin = Math.min(msMin, node.data);
		msMax = Math.max(msMax, node.data);
		msHeight = Math.max(msHeight, depth);

		for (Node child : node.children) {
			multiSolver(child, depth + 1);
		}
	}

	// pred,succ,ceil,floor
	public void multiSolver2(int data) {
		floor = null;
		ceil = null;
		multiSolver2(root, data);
		System.out.println("Floor = " + floor);
		System.out.println("Ceil = " + ceil);
		System.out.println("Predecessor = " + predecessor);
		System.out.println("Successor = " + successor);
	}

	private Integer predecessor = null;
	private Integer successor = null;
	private Integer prev = null;
	private Integer curr = null;
	private Integer ceil = null;
	private Integer floor = null;

	private void multiSolver2(Node node, int data) {
		prev = curr;
		curr = node.data;

		if (curr == data) {
			predecessor = prev;
		}

		if (prev != null && prev == data) {
			successor = curr;
		}

		if (node.data < data) {
			floor = floor == null ? node.data : Math.max(floor, node.data);
		}

		if (node.data > data) {
			ceil = ceil == null ? node.data : Math.min(ceil, node.data);
		}

		for (Node child : node.children) {
			multiSolver2(child, data);
		}
	}

	public void multiSolver3(int data) {
		ms3flag = 0;
		multiSolver3(root, data);
		System.out.println("Predecessor = " + pred);
		System.out.println("Successor = " + succ);
	}

	private Integer pred = null;
	private Integer succ = null;
	private Integer ms3flag = 0;

	private void multiSolver3(Node node, int data) {
		if (node.data == data) {
			ms3flag++;
		}
		if (ms3flag == 0) {
			pred = node.data;
		} else if (ms3flag == 1) {
			ms3flag++;
		} else if (ms3flag == 2) {
			succ = node.data;
			ms3flag++;
		} else {
			return;
		}
		for (Node child : node.children) {
			multiSolver3(child, data);
		}
	}

	public void level_Order() {    //BFS
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() > 0) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			for (Node child : temp.children) {
				queue.addLast(child);
			}
		}
		System.out.print(".");
	}

	private class pair {
		int level;
		Node nd;

		pair(Node nd, int level) {
			this.nd = nd;
			this.level = level;
		}
	}

//	public void level_OrderLineWise1() {
//		LinkedList<pair> queue = new LinkedList<>();
//		pair p = new pair(root, 0);
//		queue.addLast(p);
//		
//		while(queue.size() > 0) {
//			
//			if(rm == null) {
//				System.out.println();
//				if(queue.size() > 0) {
//					queue.addLast(null);
//				}
//				continue;
//			}
//			System.out.print(rm.data+" ");
//			for(Node child : rm.children) {
//				queue.addLast(child);
//			}
//		}
//	}

	public void level_OrderLineWise() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(null);

		while (queue.size() > 0) {
			Node rm = queue.removeFirst();

			if (rm == null) {
				System.out.println();
				if (queue.size() > 0) {
					queue.addLast(null);
				}
				continue;
			}
			System.out.print(rm.data + " ");
			for (Node child : rm.children) {
				queue.addLast(child);
			}
		}
	}

	public void level_OrderLineWise2() {
		LinkedList<Node> current_level = new LinkedList<>();
		LinkedList<Node> next_level = new LinkedList<>();

		current_level.addLast(root);

		while (current_level.size() > 0) {
			Node temp = current_level.removeFirst();
			System.out.print(temp.data + " ");

			for (Node child : temp.children) {
				next_level.addLast(child);
			}
			if (current_level.size() == 0) {
				System.out.println();
				current_level = next_level;
				next_level = new LinkedList<>();
			}
		}
	}
	
	public void level_OrderLineWise3() {
		int cl=1,nl=0;
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		
		while (queue.size() > 0) {
			Node temp = queue.removeFirst();
			cl--;
			System.out.print(temp.data + " ");

			for (Node child : temp.children) {
				queue.addLast(child);
				nl++;
			}
			if (cl == 0) {
				System.out.println();
				cl = nl;
				nl = 0;
			}
		}
	}
	
	public void level_OrderLineWise_zigZag() {
		LinkedList<Node> curr_level_queue = new LinkedList<>();
		LinkedList<Node> next_level_stack = new LinkedList<>();
		curr_level_queue.addLast(root);
		
		int level = 1;  // odds mean left to right
		while(curr_level_queue.size() > 0) {
			Node rem = curr_level_queue.removeFirst();
			System.out.print(rem.data+" ");
			
			if(level % 2 == 1) {  //L to R
				for(int i=0;i<rem.children.size();i++) {
					next_level_stack.addFirst(rem.children.get(i));
				}
			}else {
				for(int i=rem.children.size()- 1;i >= 0;i--) { //R to L
					next_level_stack.push(rem.children.get(i));
				}
			}
			
			if(curr_level_queue.size() == 0) {
				curr_level_queue = next_level_stack;
				next_level_stack = new LinkedList<>();
				System.out.println();
				level++;
			}
		}
	}
}