import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertices(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {

		if (containsVertices(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removeVertex(String vname) {

		ArrayList<String> neighbour = new ArrayList<>(vces.get(vname).keySet());
		for (String nbname : neighbour) {
			removeEdge(vname, nbname);
		}

		vces.remove(vname);
	}

	public int countEdges() {

		int count = 0;
		ArrayList<String> vnames = new ArrayList<>();
		for (String vname : vnames) {
			count += vces.get(vname).size();
		}
		return count / 2;
	}

	public boolean containsEdges(String v1name, String v2name) {
		if (containsVertices(v1name) && containsVertices(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		}
		return false;
	}

	public void addEdge(String v1name, String v2name, int wt) {
		if (containsVertices(v1name) && containsVertices(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if (containsVertices(v1name) && containsVertices(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void display() {
		System.out.println("-------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
	}

	public boolean hasPath(String src, String dest) {
		HashSet<String> visited = new HashSet<>();
		return hasPathhelper(src, dest, visited);
	}

	private boolean hasPathhelper(String src, String dest, HashSet<String> visited) {

		if (src.equals(dest)) {
			return true;
		}

		visited.add(src);
		for (String n : vces.get(src).keySet()) {
			if (visited.contains(n) == false) {
				boolean path = hasPathhelper(n, dest, visited);
				if (path) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPath(String src, String dest) {
		HashSet<String> visited = new HashSet<>();
		printAllPathHelper(src, dest, visited, src);
	}

	private void printAllPathHelper(String src, String dest, HashSet<String> visited, String psf) {

		if (src.equals(dest)) {
			System.out.println(psf);
			return;
		}

		visited.add(src);
		for (String n : vces.get(src).keySet()) {
			if (visited.contains(n) == false) {
				printAllPathHelper(n, dest, visited, psf + n);
			}
		}

		visited.remove(src);
	}

	private String sp;
	private String lp;
	private String cp;
	private String fp;

	private int spw;
	private int lpw;
	private int cpw;
	private int fpw;

	PriorityQueue<Pair> pq;

	private class Pair implements Comparable<Pair> {
		String psf;
		int wsf;

		public Pair(String psf, int wsf) {
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	public void multiSolver(String s, String d, int cf, int ff, int k) {
		sp = "";
		lp = "";
		cp = "";
		fp = "";

		spw = Integer.MAX_VALUE;
		lpw = Integer.MIN_VALUE;
		cpw = Integer.MAX_VALUE;
		fpw = Integer.MIN_VALUE;

		pq = new PriorityQueue<>();

		multisolver(s, d, new HashSet<>(), cf, ff, k, s, 0);
		System.out.println("Shortest = " + sp + "@" + spw);
		System.out.println("Longest = " + lp + "@" + lpw);
		System.out.println("Ceil = " + cp + "@" + cpw);
		System.out.println("Floor = " + fp + "@" + fpw);
		System.out.println(k + "th largest" + pq.peek().psf + "@" + pq.peek().wsf);
	}

	private void multisolver(String s, String d, HashSet<String> visited, int cf, int ff, int k, String psf, int wsf) {

		if (s.equals(d)) {
			System.out.println(psf + "@" + wsf);

			if (wsf < spw) {
				sp = psf;
				spw = wsf;
			}

			if (wsf > lpw) {
				lp = psf;
				lpw = wsf;
			}

			if (wsf > cf && wsf < cpw) {
				cp = psf;
				cpw = wsf;
			}

			if (wsf < ff && wsf > fpw) {
				fp = psf;
				fpw = wsf;
			}

			if (pq.size() < k) {
				pq.add(new Pair(psf, wsf));
			} else if (pq.size() >= k) {
				if (pq.peek().wsf < wsf) {
					pq.remove();
					pq.add(new Pair(psf, wsf));
				}
			}

			return;
		}

		visited.add(s);
		for (String n : vces.get(s).keySet()) {
			if (visited.contains(n) == false) {
				multisolver(n, d, visited, cf, ff, k, psf + n, wsf + vces.get(s).get(n));
			}
		}

		visited.remove(s);
	}

	// <---------------------------class -> 46----------------------------->
	private class TPair {
		String vertex;
		String path;
		int wt;

		public TPair(String v, String p, int w) {
			this.vertex = v;
			this.path = p;
			this.wt = w;
		}
	}

	public boolean bfs(String s, String d) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.addLast(new TPair(s, s, 0));

		HashSet<String> visited = new HashSet<>();

		while (queue.size() > 0) {
			TPair rem = queue.removeFirst();
			visited.add(rem.vertex);

			System.out.println(rem.vertex + " @ " + rem.path);

			if (rem.vertex.equals(d)) {
				return true;
			}

			for (String n : vces.get(rem.vertex).keySet()) {
				if (visited.contains(n) == false) {
					TPair np = new TPair(n, rem.path + n, rem.wt + vces.get(rem.vertex).get(n));
					queue.addLast(np);
				}
			}
		}

		return false;
	}

	public boolean dfs(String s, String d) {
		LinkedList<TPair> queue = new LinkedList<>();
		queue.addFirst(new TPair(s, s, 0));

		HashSet<String> visited = new HashSet<>();

		while (queue.size() > 0) {
			TPair rem = queue.removeFirst();
			visited.add(rem.vertex);

			System.out.println(rem.vertex + " @ " + rem.path);

			if (rem.vertex.equals(d)) {
				return true;
			}

			for (String n : vces.get(rem.vertex).keySet()) {
				if (visited.contains(n) == false) {
					TPair np = new TPair(n, rem.path + n, rem.wt + vces.get(rem.vertex).get(n));
					queue.addFirst(np);
				}
			}
		}

		return false;
	}

	public ArrayList<String> getConnectedComponent() {

		ArrayList<String> cc = new ArrayList<>();

		HashSet<String> visited = new HashSet<>();
		for (String v : vces.keySet()) {
			if (visited.contains(v) == false) {
				String comp = gccbft(v, visited);
				cc.add(comp);
			}
		}

		return cc;
	}

	private String gccbft(String s, HashSet<String> visited) {

		String comp = "";
		LinkedList<String> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {
			// 1. remove
			String rem = queue.removeFirst();

			// 2.mark
			if (visited.contains(rem)) {
				continue;
			}
			visited.add(rem);

			// 3.work
			comp += rem;

			// 4.add*
			for (String n : vces.get(rem).keySet()) {
				if (visited.contains(n) == false) {
					queue.addLast(n);
				}
			}
		}

		return comp;
	}

	public boolean isCyclic() {

		HashSet<String> visited = new HashSet<>();
		for (String v : vces.keySet()) {
			if (visited.contains(v) == false) {
				 boolean ans = isCyclicHelper(v, visited);
				 if(ans) {
					 return true;
				 }
			}
		}

		return false;
	}

	private boolean isCyclicHelper(String s, HashSet<String> visited) {
			String comp = "";
			LinkedList<String> queue = new LinkedList<>();
			queue.addLast(s);

			while (queue.size() > 0) {
				// 1. remove
				String rem = queue.removeFirst();

				// 2.mark
				if (visited.contains(rem)) {
					return true;
				}
				visited.add(rem);

				// 3.work
				comp += rem;

				// 4.add*
				for (String n : vces.get(rem).keySet()) {
					if (visited.contains(n) == false) {
						queue.addLast(n);
					}
				}
			}

			return false;
	}
	
	public boolean isConnected() {
		
		ArrayList<String> l = getConnectedComponent();
		return l.size() >= 1;
	}

	public boolean isBipartite() {

	}
}