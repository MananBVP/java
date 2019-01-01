import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQClient {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 8, 9, 7, 5, 11, 17, 1 };
		heapSort(arr);
//		printKLargest(arr, 3);
//		printKLargestBetter(arr, 3);
//		int[] arr1 = { 30, 10, 40, 20, 50, 70, 80, 60, 110, 90, 100, 120 };
//		sortAlmostSortedArray(arr1, 2);

//		MedianPQ mpq = new MedianPQ();
//		mpq.add(10);
//		System.out.println(mpq.peek());
//		mpq.add(100);
//		System.out.println(mpq.peek());
//		mpq.add(90);
//		System.out.println(mpq.peek());
//		mpq.add(80);
//		System.out.println(mpq.peek());
//		mpq.add(110);
//		System.out.println(mpq.peek());
//		mpq.add(120);
//		System.out.println(mpq.peek());
//		mpq.add(105);
//		System.out.println(mpq.peek());
//		
//		System.out.println("------------------");
//		while(mpq.size() > 0) {
//			System.out.println(mpq.remove());
//
//		ArrayList<Integer> l0 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
//		ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(22, 27, 28, 35, 55));
//		ArrayList<Integer> l2 = new ArrayList<> (Arrays.asList(11, 32, 41));
//		ArrayList<Integer> l3 = new ArrayList<> (Arrays.asList(5, 12, 26, 38));
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<> (Arrays.asList(l0,l1,l2,l3));
//		
//		mergeSortedLists(lists);

//		ArrayList<ArrayList> list = new ArrayList<>();
//		
//		ArrayList<Integer> l1 = new ArrayList<>();
//		l1.add(1);
//		l1.add(5);
//		l1.add(9);
//		l1.add(13);
//		list.add(l1);
//		l1 = new ArrayList<>();
//		l1.add(2);
//		l1.add(6);
//		l1.add(10);
//		l1.add(14);
//		list.add(l1);
//		l1 = new ArrayList<>();
//		l1.add(3);
//		l1.add(7);
//		l1.add(11);
//		l1.add(15);
//		list.add(l1);
//		l1 = new ArrayList<>();
//		l1.add(4);
//		l1.add(8);
//		l1.add(12);
//		l1.add(16);
//		list.add(l1);
	}

	
	public static void heapSort(int[] arr) {
		Heap hp = new Heap();
		
		for(int val : arr) {
			hp.add(val);
		}
		
		hp.display();
		System.out.println("---------------");
		
		while(hp.size() > 0) {
			System.out.print(hp.remove() + " ");
		}
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

	public static void sortAlmostSortedArray(int[] arr, int k) { // sapce = O(k) time = O(nlogk)

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (i < k + 1) {
				pq.add(arr[i]);
			} else {
				arr[i - k - 1] = pq.remove();
				pq.add(arr[i]);
			}
		}

		for (int i = arr.length - 1 - k; pq.size() > 0; i++) {
			arr[i] = pq.remove();
		}

		for (int j : arr) {
			System.out.print(j + " ");
		}
	}

	private static class Pair implements Comparable<Pair> {
		int lidx;
		int didx;
		int val;

		public Pair(int l, int d, int v) {
			this.lidx = l;
			this.didx = d;
			this.val = v;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;

		}
	}

	public static void mergeSortedLists(ArrayList<ArrayList<Integer>> lists) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int j = 0; j < lists.size(); j++) {
			Pair p = new Pair(j, 0, lists.get(j).get(0));
			pq.add(p);
		}

		while (pq.size() > 0) {
			Pair rp = pq.remove();
			int l = rp.lidx;
			int d = rp.didx;
			System.out.print(rp.val + " ");

			if (lists.get(l).size() > d + 1) {
				int val = lists.get(l).get(d + 1);
				Pair p2 = new Pair(l, d + 1, val);
				pq.add(p2);

			}
		}
	}

}
