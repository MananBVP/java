import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {
	private PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> max = new PriorityQueue<>();

	// O(logn)
	public void add(int data) {

		if (min.size() + max.size() < 2) {
			min.add(data);
		} else {
			if (max.peek() < data) {
				max.add(data);
			} else {
				min.add(data);
			}
		}

		if (min.size() - max.size() == 2) {
			max.add(min.remove());
		} else if (max.size() - min.size() == 2) {
			min.add(max.remove());
		}
	}

	// O(logn)
	public int remove() {
		return min.size() >= max.size() ? min.remove() : max.remove();
	}

	// O(1)
	public int peek() {
		return min.size() >= max.size() ? min.peek() : max.peek();
	}

	public int size() {
		return min.size() + max.size();
	}
}
