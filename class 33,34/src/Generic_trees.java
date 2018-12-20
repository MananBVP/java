import java.util.ArrayList;
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
			}else {
				node.children.remove(child);
			}
		}
	}
}