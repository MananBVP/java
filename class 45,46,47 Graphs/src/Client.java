
public class Client {

	public static void main(String[] args) {

		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "D", 40);
		g.addEdge("A", "B", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "F", 3);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 3);
//		g.addEdge("C", "F", 1);

//		g.display();
//		System.out.println(g.bfs("A", "G"));
//		System.out.println(g.dfs("A", "G"));
//		g.removeEdge("B", "C");
//		g.display();
//		System.out.println(g.getConnectedComponent());
//		g.removeVertex("D");
//		g.display();

//		System.out.println(g.hasPath("A", "G"));
//		g.printAllPath("A", "G");

//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
//		System.out.println(g.isBipartite());
//		g.printHamiltonianCnP("C");

//		Graph g = new Graph();
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("E");
//		g.addVertex("F");
//		
//		g.addEdge("A", "B", 2);
//		g.addEdge("A", "C", 3);
//		g.addEdge("B", "D", 4);
//		g.addEdge("C", "D", 7);
//		g.addEdge("C", "E", 1);
//		g.addEdge("D", "E", 2);
//		g.addEdge("E", "F", 3);
//		g.addEdge("D", "F", 10);

//		g.printallpaths("A", "F");
//		g.multiSolver("A", "F", 14, 15, 2);

//		isKnightsTour(new int[5][5], 1, 3, 1);
		g.Dijkstra("A");
		Graph mst = g.prims();
		mst.display();

	}

	static int[][] dirs = { { 1, 2 }, { -1, 2 }, { -1, -2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 } };
	static int num = 0;

	public static void isKnightsTour(int[][] chess, int row, int col, int counter) {

		chess[row][col] = counter;

		if (counter == chess.length * chess.length) {

			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess.length; j++) {
					System.out.print(chess[i][j] + " \t ");
				}
				System.out.println();
			}
			System.out.println(++num + "------------------");
		}

		for (int[] dir : dirs) {
			int rdash = row + dir[0];
			int cdash = col + dir[1];

			if (rdash >= 0 && cdash >= 0 && rdash < chess.length && cdash < chess[0].length) {
				if (chess[rdash][cdash] == 0) {
					isKnightsTour(chess, rdash, cdash, counter + 1);
				}

			}
		}
		chess[row][col] = 0;
	}
}
