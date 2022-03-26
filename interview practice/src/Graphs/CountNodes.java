package Graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class CountNodes {
	public static int numberOfNodesInGivenLevel(UGraph g, int source, int level) {
		int count = 0; // count initialized to zero
		int num_of_vertices = g.getVertices(); // getVertices given in Graph.java file
		HashSet<Integer> visitedNode = new HashSet<>();

		count = bfsHelper(g, source, visitedNode, level);

		return count;
	}

	public static int bfsHelper(UGraph g, int startingVertex, HashSet<Integer> visitedNode, int level) {
		java.util.Queue<Integer> q = new LinkedList<Integer>();
		q.add(startingVertex);
		visitedNode.add(startingVertex);

		int size = q.size();
		int currentLevel = 1;

		if (level == 1)
			return q.size();

		while (!q.isEmpty()) {

			int currentNode = q.remove();

			LinkedList<Integer> currentNodeAdjList = g.getAdj()[currentNode];

			for (int i = 0; i < currentNodeAdjList.size(); i++) {
				int childNode = currentNodeAdjList.get(i);
				if (!visitedNode.contains(childNode)) {
					q.add(childNode);
					visitedNode.add(childNode);
				}
			}

			size--;
			if (size == 0) {
				currentLevel++;
				size = q.size();
			}

			if (currentLevel == level)
				break;
		}

		return q.size();
	}

	public static void main(String args[]) {
		UGraph g = new UGraph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(2, 4);

		int answer;

		answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 1);
		System.out.println(answer);
		answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 2);
		System.out.println(answer);
		answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 3);
		System.out.println(answer);
		answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 4);
		System.out.println(answer);
	}
}

class UGraph {
	private int vertices; // number of vertices
	private LinkedList<Integer> adjacencyList[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	// Constructor
	UGraph(int vert) {
		this.vertices = vert;
		this.adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < this.vertices; ++i)
			this.adjacencyList[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int source, int destination) {
		this.adjacencyList[source].add(destination);
	}

	public int getVertices() {
		return this.vertices;
	}

	public LinkedList<Integer>[] getAdj() {
		return this.adjacencyList;
	}
}