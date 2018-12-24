import java.util.Stack;


public class Binary_Trees {
	
	private class Node{
		
		int data;
		Node left;
		Node right;
	}
	Node root;
	int size;
	
	public Binary_Trees(int[] arr) {
		Stack<Node> st = new Stack<>();
		for(int val : arr) {
			if(val == -1) {
				st.pop();
			}else {
				size++;
				Node node = new Node();
				node.data = val;
				if(st.size() == 0) {
					root = node;
				}else {
					if(st.peek().left == null) {
						st.peek().left = node;
					}else {
						st.peek().right = node;
					}
				}
				st.push(node);
			}
		}
	}
	
	public void display() {
		display(root);
	}
	
	private void display(Node node) {
		if(node == null) {
			return;
		}
		String str = "";
		str += node.left != null ? node.left.data : ".";
		str += " -> " + node.data + " <- ";
		str += node.right != null ? node.right.data : ".";
		
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public int size2() {
		return size2(root);
	}
	
	private int size2(Node node) {
		if(node == null) {
			return 0;
		}
		int s = 0;
		int left = size2(node.left);
		int right = size2(node.right);
		return left + right + 1;
	}
	
	public int max() {
		return max(root);
	}
	
	private int max(Node node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int left = max(node.left);
		int right = max(node.right);
		int child_max = Math.max(left, right);
		
		return Math.max(node.data, child_max);
	}
	
	public int min() {
		return min(root);
	}
	
	private int min(Node node) {
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		int left = min(node.left);
		int right = min(node.right);
		int child_min = Math.min(left, right);
		
		return Math.min(node.data, child_min);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;  // 0 for nodes height and -1 for edges height
		}
		int left = height(node.left);
		int right = height(node.right);
		return Math.max(left, right) + 1;
	}
}
