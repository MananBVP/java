import java.util.HashSet;
import java.util.PriorityQueue;

public class dijkstra {

	public static void main(String[] args) {

		Integer[][] graph = new Integer[6][6];
		graph[0][1] = 2;
		graph[0][2] = 3;
		graph[1][3] = 5;
		graph[2][4] = 3;
		graph[3][5] = 2;
		graph[4][5] = 7;
		graph[2][3] = 1;

		dijkstra(graph, 0);
	}

	private static class DPair implements Comparable<DPair> {
		int v;
		String psf;
		int wsf;

		public DPair(int v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(DPair o) {

			return this.wsf - o.wsf;
		}

	}

	public static void dijkstra(Integer[][] graph, int src) {

		PriorityQueue<DPair> pq = new PriorityQueue<>();
		HashSet<Integer> visited = new HashSet<>();
		pq.add(new DPair(src, "" + src, 0));

		while (pq.size() > 0) {
			// 1. remove
			DPair rem = pq.remove();

			// 2.mark
			if (visited.contains(rem.v)) {
				continue;
			}
			visited.add(rem.v);

			// 3.work
			System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

			// 4.add*
			for (int i = 0; i < graph.length; i++) {
				if (visited.contains(i) == false && graph[rem.v][i] != null) {
					pq.add(new DPair(i, rem.psf + i, rem.wsf + graph[rem.v][i]));
				}
			}
		}

	}
}