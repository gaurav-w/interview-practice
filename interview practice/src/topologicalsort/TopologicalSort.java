package topologicalsort;

import java.util.*;

class TopologicalSort {

  /**
  1. create hashmap for adjacency list
  2. create hasmap of indegree
  3. iterate hashmap of indegree for sources - indegreee 0 and push them into queue.
  4. while is not empty
    5. pop the element from queue - add to list
    6. reduce the indegree of itd children by 1 in hashmap
    7. if indegree of elemtn is 0 add it to queue
  8. if count != no of vertices - it is not a DAG
  */
	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> adjancencyList = new HashMap<>();
		HashMap<Integer, Integer> indegree = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < vertices; i++) {
			adjancencyList.put(i, new ArrayList<Integer>());
			indegree.put(i, 0);
		}
		
		for (int i = 0; i < edges.length; i++) {
			int source = edges[i][0];
			int end = edges[i][1];

			ArrayList<Integer> listSource = adjancencyList.get(source);
			listSource.add(end);
			adjancencyList.put(source, listSource);
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : adjancencyList.entrySet()) {
			int source = entry.getKey();
			List<Integer> list = entry.getValue();

			for (int vertex : list)
				indegree.put(vertex, indegree.get(vertex) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
			int value = entry.getValue();
			if (value == 0)
				queue.add(entry.getKey());
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int source = queue.remove();
			sortedOrder.add(source);
			count++;
			List<Integer> children = adjancencyList.get(source);

			for (int child : children) {
				indegree.put(child, indegree.get(child) - 1);

				if (indegree.get(child) == 0)
					queue.add(child);
			}
		}

		if (count != vertices)
			System.out.println("not a DAG");

		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = TopologicalSort.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}