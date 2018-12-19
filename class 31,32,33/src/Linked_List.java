
public class Linked_List {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public int getFirst() { // O(1)
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
	}

	public int getLast() { // O(1)
		if (size == 0) {
			return -1;
		}
		return tail.data;
	}

	public int getAt(int idx) { // O(n)
		if (idx < 0 || idx >= size) {
			System.out.println("Index Out of Bound");
			return -1;
		} else {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}

	public void addFirst(int data) { // O(1)
		Node node = new Node();
		node.data = data;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	private void addFirstNode(Node node) { // O(1)
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	public void addLast(int data) { // O(1)
		Node node = new Node();
		node.data = data;
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	private void addLastNode(Node node) { // O(1)
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void addAt(int idx, int data) { // O(n)
		if (idx < 0 || idx > size) {
			System.out.println("Index Out of Bound");
		} else if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node n = m1.next;
			Node node = new Node();
			node.data = data;
			size++;
			m1.next = node;
			node.next = n;
		}
	}

	public int removeFirst() { // O(1)
		Node node;
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			node = head;
			head = tail = null;
			size--;
			return node.data;
		} else {
			node = head;
			head = head.next;
			size--;
		}
		return node.data;
	}

	private Node removeFirstNode() { // O(1)
		Node node;
		if (size == 0) {
			return null;
		} else if (size == 1) {
			node = head;
			head = tail = null;
			size--;
			return node;
		} else {
			node = head;
			head = head.next;
			node.next = null;
			size--;
		}
		return node;
	}

	public int removeLast() { // O(n)
		Node node;
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			node = head;
			head = tail = null;
			size--;
			return node.data;
		} else {
			int temp = tail.data;
			Node sl = getNodeAt(size - 2);
			tail = sl;
			sl.next = null; // mandatory to allow tail to get free
			size--;
			return temp;
		}
	}

	public int removeAt(int idx) { // O(n)
		if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node node = getNodeAt(idx - 1);
			int data = node.next.data;
			node.next = node.next.next;
			size--;
			return data;
		}
	}

	public int size() { // O(1)
		return size;
	}

	public boolean isEmpty() { // O(1)
		return size == 0;
	}

	private Node getNodeAt(int idx) { // O(n)
		if (idx < 0 || idx >= size) {
			System.out.println("Index Out of Bound");
			return null;
		} else {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	public void dispaly() { // O(n)
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println(".");
	}

	public void reverseDI() { // Reverse Data Iterative O(n^2)
		int l = 0;
		int r = size - 1;
		while (l < r) {
			Node n1 = getNodeAt(l);
			Node n2 = getNodeAt(r);
			int temp = n1.data;
			n1.data = n2.data;
			n2.data = temp;
			l++;
			r--;
		}
	}

	public void reversePI() { // Reverse Pointer Iterative O(n)
		if (size == 1) {
			return;
		}
		Node a = head;
		Node b = a.next;
		Node c = b.next;
		while (b != null) {
			b.next = a;
			a = b;
			b = c;
			if (c != null) {
				c = c.next;
			}
		}
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	public boolean isPalindrome() {
		IsPalindromeLeft = head;
		return isPalindrome(head);
	}

	private Node IsPalindromeLeft;

	private boolean isPalindrome(Node right) {
		if (right == null) {
			return true;
		}
		boolean recRes = isPalindrome(right.next);
		if (recRes == true) {
			if (IsPalindromeLeft.data == right.data) {
				IsPalindromeLeft = IsPalindromeLeft.next;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void fold() {
		foldLeft = head;
		fold(head, 0);
	}

	private Node foldLeft;

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.next, floor + 1);
		if (floor > size / 2) {
			Node temp = foldLeft.next;
			foldLeft.next = right;
			right.next = temp;
			foldLeft = temp;
		}
		if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}
	}

	public int mid() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public int kthFromLast(int k) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public static Linked_List mergeTwoSortedLists(Linked_List l1, Linked_List l2) {
		Node n1 = l1.head;
		Node n2 = l2.head;
		Linked_List list = new Linked_List();
		while (n1 != null && n2 != null) {
			if (n1.data <= n2.data) {
				list.addLast(n1.data);
				n1 = n1.next;
			} else {
				list.addLast(n2.data);
				n2 = n2.next;
			}
		}
		if (n1 != null) {
			while (n1 != null) {
				list.addLast(n1.data);
				n1 = n1.next;
			}
		}
		if (n2 != null) {
			while (n2 != null) {
				list.addLast(n2.data);
				n2 = n2.next;
			}
		}
		return list;
	}

	private Node midNode() {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static Linked_List breaking(Node head, Node tail) {
		Linked_List list = new Linked_List();
		list.head = head;
		list.tail = tail;
		return list;
	}

	public static Linked_List mergesort(Linked_List list) {
		if (list.head == list.tail) {
			Linked_List newlist = new Linked_List();
			newlist.addLast(list.head.data);
			return newlist;
		}
		Node mid = list.midNode();
		Node midn = mid.next;
		mid.next = null;
		Linked_List left, right;
		left = breaking(list.head, mid);
		right = breaking(midn, list.tail);
		left = mergesort(left);
		right = mergesort(right);
		Linked_List sorted = mergeTwoSortedLists(left, right);
		mid.next = midn;
		return sorted;
	}

	public void kReverse(int k) {
		Linked_List prev = new Linked_List();
		Linked_List curr = null;
		while (this.size != 0) {
			for (int i = 0; i < k && this.size != 0; i++) {
				prev.addFirstNode(this.removeFirstNode());
			}
			if (curr == null) {
				curr = prev;
			} else {
				curr.tail.next = prev.head;
				curr.tail = prev.head;
				curr.size += prev.size;
			}

			prev = new Linked_List();

		}
		this.head = curr.head;
		this.tail = curr.tail;
		this.size = curr.size;
	}

	public void removeDuplicates() {
		Linked_List newlist = new Linked_List();

		while (this.size != 0) {
			if (newlist.head == null) {
				newlist.addLastNode(this.removeFirstNode());
			} else {
				if (newlist.tail.data == this.head.data) {
//					this.head = head.next;
//					this.size--;
					this.removeFirstNode();
				} else {
					newlist.addLastNode(this.removeFirstNode());
				}
			}
		}
		this.head = newlist.head;
		this.tail = newlist.tail;
		this.size = newlist.size;
	}
}