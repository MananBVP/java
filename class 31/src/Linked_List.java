
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

	public void reverseDI() { // Reverse Data Iterative
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

	public void reversePI() { // Reverse Pointer Iterative
		if(size==1) {
			return;
		}
		Node a=head;
		Node b=a.next;
		Node c=b.next;
		while(b!=null) {
			b.next=a;
			a=b;
			b=c;
			if(c!=null) {
				c=c.next;
			}
		}
		Node temp=head;
		head=tail;
		tail=temp;
		tail.next=null;
	}
}
