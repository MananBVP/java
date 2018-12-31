import java.util.Collections;
import java.util.PriorityQueue;

public class PQClient {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 8, 9, 7, 5 };
		printKLargest(arr, 3);

	}

	public static void printKLargest(int[] arr, int k) { // space = O(n) time = O(n + k)logn

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int val : arr) {
			pq.add(val);
		}

		for (int i = 0; i < k; i++) {
			System.out.print(pq.remove() + " ");
		}
	}

	public static void printKLargestBetter(int[] arr, int k) { // space = O(k) time = O(nlogk)

	}
}
