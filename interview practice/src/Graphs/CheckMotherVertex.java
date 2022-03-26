package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class CheckMotherVertex {

	public static int findMotherVertex(Graph g) {
		int count = g.vertices;

		for (int i = 0; i < count; i++) {
			HashSet set = bfs(g, i);

			if (set.size() == count)
				return i;
		}

		return -1;
	}

	public static HashSet bfs(Graph g, int vertex) {
		HashSet<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);

		while (!q.isEmpty()) {
			int node = q.remove();
			set.add(node);

			DoublyLinkedList<Integer> adjacentList = g.adjacencyList[node];
			DoublyLinkedList.Node child = adjacentList.getHeadNode();

			while (child != null) {
				if (!set.contains(child.data))
					q.add((int) child.data);

				child = child.nextNode;
			}
		}

		return set;
	}

	
	
    
	public static void main(String args[]) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 0);
		g.addEdge(3, 1);
		g.printGraph();
		System.out.println("Mother Vertex is: " + findMotherVertex(g));

	}
}