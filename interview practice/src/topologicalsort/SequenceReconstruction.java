package topologicalsort;

import java.util.*;

/**
1. initlize the adjancency matric and lindegree
2. create a adjancency matrix along with indegree calc
3. Create a list of Int for result.
4. input indegree 0 in q
5. call the method topologicalsort

topological sort(){
  6. while q is not empty

    7. iterate over all elementf in q
    8. create clone of the list
    9.  remove the vertex from queue (vertex - v )
		10. add to list
		11. decrease indegree of its children
		12. if indegree is 0 add to queue
		13. recall the function
		
		backtrack
		10r. add to queue (vertex - v )
		10r. remove from list (vertex - v )
		11r. increase indegree of its children(vertex - v )
  12. add to result if size = origi seq
  13. if result size more than 1 return false.
}

//incorrect way to solve
**/
class SequenceReconstruction {
	public static boolean canConstruct(int[] originalSeq, int[][] sequences) {

		HashMap<Integer, ArrayList<Integer>> adjMat = new HashMap<>();
		HashMap<Integer, Integer> indegree = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < originalSeq.length; i++) {
			int element = originalSeq[i];
			adjMat.put(element, new ArrayList());
			indegree.put(element, 0);
		}

		for (int i = 0; i < sequences.length; i++) {

			int parent = sequences[i][0];
			int child = sequences[i][1];

			adjMat.get(parent).add(child);
			indegree.put(child, indegree.get(child) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0)
				q.add(entry.getKey());
		}
		
		topologicalSort(adjMat, indegree, q, result);

		if (result.size() == indegree.size())
			return true;
		return false;
	}

	public static void topologicalSort(HashMap<Integer, ArrayList<Integer>> adjMat, HashMap<Integer, Integer> indegree,
			Queue<Integer> q, ArrayList<Integer> result) {
	//	ArrayList<Integer> temp = new ArrayList<>();

		while (!q.isEmpty()) {

			for (int vertex : q) {

				Queue<Integer> nextCallQ = cloneQueue(q);
				nextCallQ.remove(vertex);
				result.add(vertex);
				
				List<Integer> children = adjMat.get(vertex);
				
				for (Integer child : children ) {
					indegree.put(child, indegree.get(child) - 1);

					if (indegree.get(child) == 0)
						nextCallQ.add(child);
				}

				topologicalSort(adjMat, indegree, nextCallQ, result);

				// backtrack
				result.remove(new Integer(vertex));
				for (Integer child : children) {
					indegree.put(child, indegree.get(child) + 1);
				}
				
				if (result.size() == indegree.size()) {
					break;
				}
			}
		}

		

	}

	public static Queue<Integer> cloneQueue(Queue<Integer> q) {
		Queue<Integer> q2 = new LinkedList<>();
		for (int vertex : q) {
			q2.add(vertex);
		}

		return q2;
	}

	public static void main(String[] args) {
		boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
		System.out.println("Can we uniquely construct the sequence: " + result);

		result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
		System.out.println("Can we uniquely construct the sequence: " + result);

		result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
				new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
		System.out.println("Can we uniquely construct the sequence: " + result);
	}
}