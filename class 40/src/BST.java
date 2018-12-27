
public class BST {
	private class Node {

		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;
	
	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}
	
	private Node construct(int[] sa , int lo , int hi) {
		Node node = new Node();
		if(lo > hi) {
			return null;
		}
		
		
		int mid = (lo + hi) / 2;
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		
		return node;
	}
	
	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
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
}
