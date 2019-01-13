import java.util.Collections;
import java.util.PriorityQueue;


public class jobSelection {

	public static void main(String[] args) {
		
		Integer[] d = {4,2,3,1,8,3,2,1,2,6,5,7,9,2,6,5,2,7,6,9,1,6};
		Integer[] p = {100,69,94,54,33,77,11,99,37,76,34,47,78,45,39,75,49,34,48,92,44,90};
		Character[] act = {'a','b','d','e','c','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v'};
		
		jobSequencing(act, d, p);
	}
	
	private static class Pair implements Comparable<Pair>{
		Character act;
		int d;
		int p;
		
		public Pair(Character act, int d, int p) {
			this.act = act;
			this.d = d;
			this.p = p;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.p - o.p;
		}
	}
	
	
	public static void jobSequencing(Character[] act, Integer[] d, Integer[] p) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		int maxdl = 0;
		
		for(int i = 0; i<act.length; i++) {
			pq.add(new Pair(act[i], d[i], p[i]));
			maxdl = Math.max(maxdl, d[i]);
		}
		
		int[] free = new int[maxdl + 1];
		char[] res = new char[maxdl + 1];
		
		for(int i = 0; i < free.length; i++) {
			free[i] = i;
		}
		
		while(pq.size() > 0) {
			Pair rem = pq.remove();
			int rf = find(free, rem.d);
			if(rf > 0) {
				res[rf] = rem.act;
				int rfm1 = find(free, rf - 1);
				free[rf] = rfm1;
			}
		}
		
		System.out.println(res);
	}
	
	private static int find(int[] free, int d) {

		if (free[d] == d) {
			return d;
		}
		else {
			int rf = find(free, free[d]);
			free[d] = rf;
			return rf;
		}
	}

}
