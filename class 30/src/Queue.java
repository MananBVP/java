
public class Queue {

	protected int[] arr;
	protected int front = 0;
	protected int size = 0;

	public Queue(int cap) {
		this.arr = new int[cap];
	}

	public void enQueue(int val) {
		if (size == arr.length) {
			System.out.println("Queue is full");
			return;
		}
		int last = (front + size) % arr.length;
		arr[last] = val;
		size++;
	}

	public int deQueue() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		int val = arr[front];
		arr[front] = 0;
		front = (front + 1) % arr.length;
		size--;
		return val;
	}

	public int front() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		int val = arr[front];
		return val;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void dispaly() {
		for (int i = 0; i < size; i++) {
			int idx = (front + i) % arr.length;
			System.out.print(arr[idx] + " ");
		}
		System.out.println(".");
	}
}
