
public class Linked_List<T> {
	private class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public T getFirst() { // O(1)
		if (size == 0) {
			return null;
		} else {
			return head.data;
		}
	}

	public T getLast() { // O(1)
		if (size == 0) {
			return null;
		}
		return tail.data;
	}

	public T getAt(int idx) { // O(n)
		if (idx < 0 || idx >= size) {
			System.out.println("Index Out of Bound");
			return null;
		} else {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}

	public void addFirst(T data) { // O(1)
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

	public void addLast(T data) { // O(1)
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

	public void addAt(int idx, T data) { // O(n)
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

	public T removeFirst() { // O(1)
		Node node;
		if (size == 0) {
			return null;
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

	public T removeLast() { // O(n)
		Node node;
		if (size == 0) {
			return null;
		} else if (size == 1) {
			node = head;
			head = tail = null;
			size--;
			return node.data;
		} else {
			T temp = tail.data;
			Node sl = getNodeAt(size - 2);
			tail = sl;
			sl.next = null; // mandatory to allow tail to get free
			size--;
			return temp;
		}
	}

	public T removeAt(int idx) { // O(n)
		if (idx < 0 || idx >= size) {
			System.out.println("Index out of bound");
			return null;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node node = getNodeAt(idx - 1);
			T data = node.next.data;
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

}