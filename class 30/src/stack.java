
public class stack {
	protected int[] arr;
	protected int tos = -1;

	public stack(int cap) {
		this.arr = new int[cap];
	}

	public void push(int val) {
		if (tos == arr.length - 1) {
			System.out.println("Stack overflow");
			return;
		}
		tos++;
		arr[tos] = val;
	}

	public int top() {
		if (tos == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
		int top = arr[tos];
		return top;
	}

	public int pop() {
		if (tos == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
		int val = arr[tos];
		arr[tos] = 0;
		tos--;
		return val;
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return tos == -1;
	}

	public void display() {
		for (int i = tos; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(".");
	}
}
