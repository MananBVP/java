import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

		HashMap<String, HashMap<String, Boolean>> hp = new HashMap<>();

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

	public void smallestPnW(String s, String d) {

	}

	public void largestPnW(String s, String d) {

	}

	public void smallestPnW(String s, String d) {

	}

	public void smallestPnW(String s, String d) {

	}
}