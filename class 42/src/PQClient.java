import java.util.Collections;
import java.util.PriorityQueue;

public class PQClient {

	public static void main(String[] args) {
//		int[] arr = { 2, 3, 6, 8, 9, 7, 5, 11, 17, 1 };
//		printKLargest(arr, 3);
//		printKLargestBetter(arr, 3);
		int[] arr1 = { 30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120 };
		sortAlmostSortedArray(arr1, 2);

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
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(arr[0]);

		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				pq.add(arr[i]);
			} else if (arr[i] > pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}

		System.out.print(pq);
	}

	public static void sortAlmostSortedArray(int[] arr, int k) { //sapce = O(k) time = O(nlogk)

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i =0; i < arr.length; i++) {
			if (i < k + 1) {
				pq.add(arr[i]);
			} else {
				arr[i - k -1] = pq.remove();
				pq.add(arr[i]);
			}
		}
		
		for(int i = arr.length-1-k;pq.size()>0;i++) {
			arr[i]=pq.remove();
		}
		
		for(int j : arr) {
			System.out.print(j + " ");
		}
	}
}
