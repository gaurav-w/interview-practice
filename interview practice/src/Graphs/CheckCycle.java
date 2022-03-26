package Graphs;

import java.util.HashSet;

class CheckCycle {
	// Depth First Traversal of Graph g
	public static boolean detectCycle(Graph g) {
		int vertexCount = g.vertices;
		HashSet visited = new HashSet();
		HashSet visiting = new HashSet();
		boolean result = false;
		for (int i = 0; i < vertexCount; i++) {

			if (!visited.contains(i))
				result = result || dfsHelper(g, visited, visiting, i);

		}

		return result;
	}

	public static boolean dfsHelper(Graph g, HashSet visited, HashSet visiting, int vertex) {

		// visiting current node
		if (visiting.contains(vertex))
			return true;

		visiting.add(vertex);

		DoublyLinkedList currentIndexAdjacents = g.adjacencyList[vertex];
		DoublyLinkedList.Node adjacentNode = currentIndexAdjacents.getHeadNode();

		while (adjacentNode != null) {
			int nodeNo = (int) adjacentNode.data;

			if (!visited.contains(nodeNo))
				dfsHelper(g, visited, visiting, nodeNo);
			else
				return true;

			adjacentNode = adjacentNode.nextNode;
		}

		visiting.remove(vertex);
		visited.add(vertex);

		return false;
	}

	public static void main(String args[]) {
		Graph g1 = new Graph(4);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(3, 0);
		g1.printGraph();
		System.out.println(detectCycle(g1));

		System.out.println();
		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.printGraph();
		System.out.println(detectCycle(g2));
	}
}