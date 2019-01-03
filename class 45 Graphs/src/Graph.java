import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertices(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		
		if(containsVertices(vname) == false) {
			vces.put(vname, new HashMap<>());
		}
	}

	public void removeVertex(String vname) {
		
		ArrayList<String> neighbour = new ArrayList<>(vces.get(vname).keySet());
		for(String nbname: neighbour) {
			removeEdge(vname, nbname);
		}
		
		vces.remove(neighbour);
	}

	public int countEdges() {

		int count = 0;
		ArrayList<String> vnames = new ArrayList<>();
		for(String vname : vnames) {
			count += vces.get(vname).size();
		}
		return count / 2;
	}

	public boolean containsEdges(String v1name, String v2name) {
		if(containsVertices(v1name) && containsVertices(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		}
		return false;
	}

	public void addEdge(String v1name, String v2name, int wt) {
		if(containsVertices(v1name) && containsVertices(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public void removeEdge(String v1name, String v2name) {
		if(containsVertices(v1name) && containsVertices(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}
	
	public void display() {
		System.out.println("-------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for(String vname : vnames) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
	}
}
