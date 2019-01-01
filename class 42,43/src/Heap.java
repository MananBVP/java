import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();

	public Heap(int[] arr) {
		
//		for(int val : arr) {  takes nlogn time for n size array
//			add(val);
//		}
		for(int val : arr) { // takes O(n) time for n size array
			data.add(val);
		}
		
		for(int i = data.size() / 2 - 1; i >= 0; i--) {
			downHeapify(i);
		}
	}
	
	public void add(int val) {

		data.add(val);
		upHeapify(data.size() - 1);
	}

	private void upHeapify(int ci) {

		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upHeapify(pi);
		}
	}

	public int peek() {
		return data.get(0);
	}

	public int remove() {

		swap(0, data.size() - 1);
		int rv = data.remove(data.size() - 1);
		downHeapify(0);
		return rv;
	}

	private void downHeapify(int pi) {

		int mini = pi;

		int lci = (2 * pi) + 1;
		if (lci < data.size() && data.get(lci) < data.get(pi)) {
			mini = lci;
		}

		int rci = (2 * pi) + 2;
		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downHeapify(mini);
		}
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
}
