package Graphs;

import java.util.*;

public class CheckMin {
	public static int findShortestPathLength(Graph g, int source, int destination) {

		int distance = findShortestPathLengthHelper(g, source, destination);
		return distance;
	}

	public static int findShortestPathLengthHelper(Graph g, int source, int destination) {
		HashSet<Integer> visited = new HashSet<>();
		HashMap<Integer, Integer> distance = new HashMap<>();
		Queue<Integer> q = new Queue<>(g.vertices);
		q.enqueue(source);
		distance.put(source, 0);

		while (!q.isEmpty()) {
			int parent = q.dequeue();
			visited.add(parent);
			DoublyLinkedList childNodesList = g.adjacencyList[parent];
			DoublyLinkedList<Integer>.Node child = childNodesList.getHeadNode();

			while (child != null) {
				if (!visited.contains(child)) {
					distance.put((int) child.data, distance.get(parent) + 1);
					q.enqueue((int) child.data);
				}

				if ((int) child.data == destination)
					return distance.get(destination);

				child = child.nextNode;
			}

		}

		return -1;
	}

	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		System.out.println(findShortestPathLength(g, 0, 4));
	}
}