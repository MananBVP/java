import java.util.ArrayList;
import java.util.Stack;

import Binary_Trees.pair1;

public class Binary_Trees {

	private class Node {

		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	public Binary_Trees(int[] arr) {
		Stack<Node> st = new Stack<>();
		for (int val : arr) {
			if (val == -1) {
				st.pop();
			} else {
				size++;
				Node node = new Node();
				node.data = val;
				if (st.size() == 0) {
					root = node;
				} else {
					if (st.peek().left == null) {
						st.peek().left = node;
					} else {
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

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
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
		if (node == null) {
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
		if (node == null) {
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
		if (node == null) {
			return 0; // 0 for nodes height and -1 for edges height
		}
		int left = height(node.left);
		int right = height(node.right);
		return Math.max(left, right) + 1;
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

		boolean filc = find(node.left, data);
		if (filc) {
			return true;
		}
		boolean firc = find(node.right, data);
		if (firc) {
			return true;
		}
		return false;

//		boolean found = false;
//		found = found || node.data == data;
//		found = found || find(node.left,data);
//		found = found || find(node.right,data);
//		return found;
	}

	public void printSingleChild() {
		printSingleChild(root, root.left);
		printSingleChild(root, root.right);
	}

	private void printSingleChild(Node parent, Node child) {
		if (child == null) {
			return;
		}

		if ((parent.left == child && parent.right == null) || (parent.right == child && parent.left == null)) {
			System.out.print(child.data + " ");
		}

		printSingleChild(child, child.left);
		printSingleChild(child, child.right);
	}

	public void removeLeaf() {
		removeLeaf(root, root.left);
		removeLeaf(root, root.right);
	}

	private void removeLeaf(Node parent, Node child) {
		if (child == null) {
			return;
		}

		if (child.left == null && child.right == null) {
			// leaf
			if (parent.left == child) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		removeLeaf(child, child.left);
		removeLeaf(child, child.right);
	}

	public ArrayList<Integer> rootToNodePath(int data) {
		return rootToNodePath(root, data);
	}

	private ArrayList<Integer> rootToNodePath(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}
		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(node.data);
			return path;
		}

		ArrayList<Integer> pathfromLC = rootToNodePath(node.left, data);
		if (pathfromLC.size() > 0) {
			pathfromLC.add(node.data);
			return pathfromLC;
		}

		ArrayList<Integer> pathfromRC = rootToNodePath(node.right, data);
		if (pathfromRC.size() > 0) {
			pathfromRC.add(node.data);
			return pathfromRC;
		}

		return new ArrayList<>();
	}

	private void printKDown() {

	}

	public void rootToNodePaths(int tar) {
		rootToNodePaths(root, 0, " ", tar);
	}

	private void rootToNodePaths(Node node, int asf, String psf, int tar) {
		if (node == null) {
			return;
		}
		
	}

	// <-------------------class 38 ------------->

	public Binary_Trees(int[] postO, int[] inO) {
//		root = construct(preO, 0, preO.length - 1, inO, 0, inO.length - 1);
		root = construct1(postO, 0, postO.length - 1, inO, 0, inO.length - 1);
	}

	private Node construct(int[] preO, int psi, int pei, int[] inO, int isi, int iei) {
		if (isi > iei && psi > pei) {
			return null;
		}
		// node , data ,left , right , return
		Node node = new Node();
		node.data = preO[psi];
		size++;

		int idx = -1;

		for (int i = isi; i <= iei; i++) {
			if (inO[i] == node.data) {
				idx = i;
				break;
			}
		}

		int lhs = idx - isi;
		node.left = construct(preO, psi + 1, psi + lhs, inO, isi, idx - 1);
		node.right = construct(preO, psi + lhs + 1, pei, inO, idx + 1, iei);
		return node;
	}

	private Node construct1(int[] postO, int psi, int pei, int[] inO, int isi, int iei) {
		if (isi > iei && psi > pei) {
			return null;
		}
		Node node = new Node();
		node.data = postO[pei];
		size++;

		int idx = -1;

		for (int i = isi; i <= iei; i++) {
			if (inO[i] == node.data) {
				idx = i;
				break;
			}
		}

		int lhs = idx - isi;
		node.left = construct1(postO, psi + 0, psi + lhs - 1, inO, isi, idx - 1);
		node.right = construct1(postO, psi + lhs, pei - 1, inO, idx + 1, iei);
		return node;
	}

	private class Pair {
		Node node;
		int wc = 0;

		public Pair(Node node, int wc) {
			this.node = node;
			this.wc = wc;
		}
	}

	public void preOIterative() {
		Stack<Pair> stack = new Stack<>();
		Pair rtp = new Pair(root, 0);
		stack.push(rtp);

		while (stack.size() > 0) {
			Pair tp = stack.peek();
			if (tp.wc == 0) {
				System.out.println(tp.node.data + " ");
			} else if (tp.wc == 1) {
				if (tp.node.left != null) {
					Pair lp = new Pair(tp.node.left, 0);
					stack.push(lp);
				}
			} else if (tp.wc == 2) {
				if (tp.node.right != null) {
					Pair rp = new Pair(tp.node.right, 0);
					stack.push(rp);
				}
			} else {
				stack.pop();
			}
			tp.wc++;
		}
	}

	public void postOIterative() {
		Stack<Pair> stack = new Stack<>();
		Pair rtp = new Pair(root, 0);
		stack.push(rtp);

		while (stack.size() > 0) {
			Pair tp = stack.peek();
			if (tp.wc == 0) {
				if (tp.node.left != null) {
					Pair lp = new Pair(tp.node.left, 0);
					stack.push(lp);
				}

			} else if (tp.wc == 1) {
				if (tp.node.right != null) {
					Pair rp = new Pair(tp.node.right, 0);
					stack.push(rp);
				}
			} else if (tp.wc == 2) {
				System.out.println(tp.node.data + " ");
			} else {
				stack.pop();
			}
			tp.wc++;
		}
	}

	public void inOIterative() {
		Stack<Pair> stack = new Stack<>();
		Pair rtp = new Pair(root, 0);
		stack.push(rtp);

		while (stack.size() > 0) {
			Pair tp = stack.peek();
			if (tp.wc == 0) {
				if (tp.node.left != null) {
					Pair lp = new Pair(tp.node.left, 0);
					stack.push(lp);
				}

			} else if (tp.wc == 1) {
				System.out.println(tp.node.data + " ");
			} else if (tp.wc == 2) {
				if (tp.node.right != null) {
					Pair rp = new Pair(tp.node.right, 0);
					stack.push(rp);
				}
				
			} else {
				stack.pop();
			}
			tp.wc++;
		}
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node node) {
		if(node == null) {
			return true;
		}
		
		int h = height(node.left) - height(node.right);
		if(h < -1 && h > 1) {
			return false;
		}
		
		
		return true && isBalanced(node.left) && isBalanced(node.right);
		
	}
	
	private class BalPair{
		boolean Balanced;
		int height;
		}
		
	public boolean IsBalanced() {
		return IsBalanced(root).Balanced;
	}
	private BalPair IsBalanced(Node node) {
		if(node == null) {
			BalPair bp = new BalPair();
			bp.height = 0;
			bp.Balanced = true;
			return bp;
		}
		BalPair lp = IsBalanced(node.left);
		BalPair rp = IsBalanced(node.right);
		
		BalPair mp = new BalPair();
		mp.height = Math.max(lp.height, rp.height) + 1 ;
		mp.Balanced = lp.Balanced && rp.Balanced && ( Math.abs(lp.height - rp.height) <= 1);
		return mp;
	}
	
	//<--------------------class 39---------------------->
	
		public boolean isBST() {
			return isBST(root);
		}
		
		private boolean isBST(Node node) {
			if(node == null) {
				return true;
			}
			
			int max = max(node.left);
			int min = min(node.right);
			
			if(node.data < max  || node.data > min) {
				return false;
			}
			
			boolean lbs = isBST(node.left);
			if(lbs == false) {
				return false;
			}
			
			boolean rbs = isBST(node.right);
			if(rbs == false) {
				return false;
			}
			
			return true;
		}
		
		private class BstPair{
			int max;
			int min;
			boolean isBST;
		}
		
		public boolean isBST1() {
			return isBST(root);
		}
		
		private BstPair isBST1(Node node) {
			
		}
	}

