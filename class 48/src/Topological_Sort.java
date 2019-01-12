import java.util.HashSet;
import java.util.Stack;

public class Topological_Sort {

	public static void main(String[] args) {

		boolean[][] graph = { { false, true, false, true, false, false }, { false, false, true, false, false, false },
				{ false, false, false, true, false, false }, { false, false, false, false, false, false },
				{ false, false, false, true, false, true }, { false, false, true, false, false, false } };

		topologicalSort(graph);
	}

	static Stack<Integer> st = new Stack<>();
	public static void topologicalSort(boolean[][] graph) {

		HashSet<Integer> visited = new HashSet<>();

		for (int i = 0; i < graph.length; i++) {
			if(visited.contains(i) == false) {
				topologicalSort(graph, visited, i);
			}
		}
		
		while(st.size() > 0) {
			System.out.println(st.pop() + " ");
		}

	}

	private static void topologicalSort(boolean[][] graph, HashSet<Integer> visited, int root) {
		visited.add(root);
		
		for (int i = 0; i < graph.length; i++) {
			if(visited.contains(i) == false && graph[root][i] == true) {
				topologicalSort(graph, visited, i);
			}
		}
		
		st.push(root);
	}
}
