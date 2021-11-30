package heaps;

import java.util.*;

class TaskScheduler {

	/*
	 * 1. char frq map 2. add to PQ - maxQ 3. Queue 4. while PQ ia not empty || q is
	 * not empty a.if(PQ is empty) add i to builder b. else{ remove top from PQ add
	 * currentElement to builder add currentElement to Q if( currentK > k) add top
	 * of Q back to PQ }
	 * 
	 */

	public static int scheduleTasks(char[] tasks, int k) {

		HashMap<Character, Integer> freqMap = new HashMap<>();
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());
		Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
		HashMap<Integer, Map.Entry<Character, Integer>> kMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int currentK = 0;

		for (Character c : tasks)
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

		Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();
		for (Map.Entry<Character, Integer> entry : entrySet)
			maxHeap.add(entry);

		while (!maxHeap.isEmpty() || !kMap.isEmpty()) {
			currentK++;

			if (currentK == k + 1)
				currentK = 1;

			if (!maxHeap.isEmpty()) {
				Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
				sb.append(currentEntry.getKey());

				currentEntry.setValue(currentEntry.getValue() - 1);

				if (currentEntry.getValue() != 0 && currentK != 0)
					kMap.put(currentK, currentEntry);
			}

			if (kMap.get(currentK) != null) {
				maxHeap.add(kMap.get(currentK));
				kMap.remove(currentK);
			} else
				sb.append("i");

		}
		return sb.length();
	}

	public static int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> counts = new HashMap();
		for (char t : tasks)
			counts.put(t, counts.getOrDefault(t, 0) + 1);
		PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
		pq.addAll(counts.values());

		int result = 0;
		while (!pq.isEmpty()) {
			int time = 0;
			List<Integer> tmp = new ArrayList();
			for (int i = 0; i < n + 1; ++i) {
				if (!pq.isEmpty()) {
					tmp.add(pq.remove() - 1);
					time++;
				}
			}
			for (int t : tmp)
				if (t > 0)
					pq.add(t);
			result += pq.isEmpty() ? time : n + 1;
		}
		return result;
	}

	public static int scheduleTasks2(char[] tasks, int k) {
		int intervalCount = 0;
		Map<Character, Integer> taskFrequencyMap = new HashMap<>();
		for (char chr : tasks)
			taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		// add all tasks to the max heap
		maxHeap.addAll(taskFrequencyMap.entrySet());

		while (!maxHeap.isEmpty()) {
			List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
			int n = k + 1; // try to execute as many as 'k+1' tasks from the max-heap
			for (; n > 0 && !maxHeap.isEmpty(); n--) {
				intervalCount++;
				Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
				if (currentEntry.getValue() > 1) {
					currentEntry.setValue(currentEntry.getValue() - 1);
					waitList.add(currentEntry);
				}
			}
			maxHeap.addAll(waitList); // put all the waiting list back on the heap
			if (!maxHeap.isEmpty())
				intervalCount += n; // we'll be having 'n' idle intervals for the next iteration
		}

		return intervalCount;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.leastInterval(tasks, 2));

		tasks = new char[] { 'a', 'b', 'a' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
	}
}