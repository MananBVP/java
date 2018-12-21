import java.text.spi.CollatorProvider;
import java.util.ArrayList;
import java.util.Collections;
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

	public boolean isSymmetric() {
		return Generic_trees.areMirrorImages(this, this);
	}
	
	public void multiSolver() {
		msSize=0;
		msMin=Integer.MAX_VALUE;
	    msMax=Integer.MIN_VALUE;
	    msHeight=0;
		multiSolver(root, 0);
		
		System.out.println("Size = "+msSize);
		System.out.println("Max = "+msMax);
		System.out.println("Min = "+msMin);
		System.out.println("Height = "+msHeight);
	}
	private int msSize=0;
	private int msMin=Integer.MAX_VALUE;
	private int msMax=Integer.MIN_VALUE;
	private int msHeight=0;
	
	private void multiSolver(Node node , int depth) {
		msSize++;
		msMin=Math.min(msMin, node.data);
		msMax=Math.max(msMax, node.data);
		msHeight=Math.max(msHeight, depth);
		
		for(Node child : node.children) {
			multiSolver(child, depth+1);
		}
	}
}