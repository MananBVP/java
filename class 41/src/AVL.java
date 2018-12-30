
public class AVL {
	private class Node {

		int data;
		Node left;
		Node right;
		int height;
		int balance;
	}

	private Node root;
	private int size;

	public AVL(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		Node node = new Node();
		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);
		this.sethnb(node);
		size++;
		return node;
	}

	private void sethnb(Node node) {
		int lh = node.left != null ? node.left.height : 0;
		int rh = node.right !=null ? node.right.height : 0;
		
		node.height = Math.max(lh , rh) + 1 ;
		node.balance = lh - rh;
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
		str += " -> " + node.data + "[" +  node.height + "," + node.balance + "]<-" ;
		str += node.right != null ? node.right.data : ".";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}

		return min(node.left);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

//		return node.data > data ? find(node.left , data) : find(node.right, data);
		if (node.data > data) {
			return find(node.left, data);
		} else {
			return find(node.right, data);

		}
	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.data >= lo && node.data <= hi) {
			printInRange(node.left, lo, hi);
			System.out.print(node.data + " ");
			printInRange(node.right, lo, hi);
		} else if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		}
	}

	private int rsum;

	public void replaceWithSumOfLargerNodes() {
		rsum = 0;
		replaceWithSumOfLargerNodes(root);
	}

	private void replaceWithSumOfLargerNodes(Node node) {
		if (node == null) {
			return;
		}

		replaceWithSumOfLargerNodes(node.right);

		int ond = node.data;
		node.data = rsum;
		rsum += ond;

		replaceWithSumOfLargerNodes(node.left);
	}

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (node == null) {
			Node node1 = new Node();
			node1.data = data;
			node1.height = 1;
			return node1;
		}

		if (data < node.data) {
			node.left = add(node.left, data);
		} else if (data > node.data) {
			node.right = add(node.right, data);
		}
		
		sethnb(node);
		
		if(node.balance > 1 && data < node.data) { //ll
			node = rightRotate(node);
		}else if(node.balance > 1 && data > node.data) { //lr
			node.left = leftRotate(node.left);
			node = rightRotate(node);
		}else if(node.balance < -1 && data > node.data) { //rr
			node = leftRotate(node);
		}else if(node.balance < -1 && data < node.data) { //rl
			node.right = rightRotate(node.right);
			node = leftRotate(node);
		}

		
		return node;
		
	}
	
	private Node rightRotate(Node z) {
		Node y = z.left;
		Node t3 = y.right;
		y.right = z;
		z.left = t3;
		
		sethnb(z);
		sethnb(y);
		return y;
	}
	
	private Node leftRotate(Node z) {
		Node y = z.right;
		Node t3 = y.left;
		y.left = z;
		z.right = t3;
		
		sethnb(z);
		sethnb(y);
		return y;
	}

	public void remove(int data) {
		root = remove(root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data < node.data) {
			node.left = remove(node.left, data);
		}

		if (data > node.data) {
			node.right = remove(node.right, data);
		}
		if (node.data == data) {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null || node.right == null) {
				if (node.left != null) {
					return node.left;
				} else {
					return node.right;
				}
			} else {
				int temp = max(node.left);
				node.data = temp;
				node.left = remove(node.left, temp);
				return node;
			}
		}

		return node;

	}

	public int LCA(int lo, int hi) {
		return LCA(root, lo, hi);
	}

	private int LCA(Node node, int lo, int hi) {
		if (node == null) {
			return -1;
		}

		if (node.data < lo) {
			return LCA(node.right, lo, hi);
		} else if (node.data > hi) {
			return LCA(node.left, lo, hi);
		}else {
			return node.data;
		}
	}
	
	public void printTargetSumPair(int target) {
		printTargetSumPair(root, target);
	}
	
	private void printTargetSumPair(Node node , int target) {
		if(node == null) {
			return;
		}
		printTargetSumPair(node.left, target);
		
		int comp = target - node.data;
		
		if(node.data < comp) {
			boolean ans = find(comp);
			if(ans) {
				System.out.println(node.data+" "+comp);
			}
		}
	
		printTargetSumPair(node.right, target);
	}
}
