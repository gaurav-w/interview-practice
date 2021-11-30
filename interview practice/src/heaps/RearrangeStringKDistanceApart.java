package heaps;

import java.util.*;

/**
 * 1. freq map 2. make PQ from map. 3. if PQ element is present in queue of k-1
 * then return "" else poll from PQ add to builder add to PQ with decrement
 * count add to queue if elements in queue greater than K-1 remove first element
 * 
 * 
 */
class RearrangeStringKDistanceApart {

	public static String reorganizeString(String str, int k) {
		HashMap<Character, Integer> freqMap = new HashMap<>();
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());
		Queue<Map.Entry<Character, Integer>> frqUsedCharQ = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for (Character c : str.toCharArray())
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

		Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();
		for (Map.Entry<Character, Integer> entry : entrySet)
			maxHeap.add(entry);

		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
			Character currentChar = currentEntry.getKey();

			sb.append(currentChar);

			currentEntry.setValue(currentEntry.getValue() - 1);
			frqUsedCharQ.add(currentEntry);

			if (frqUsedCharQ.size() > k - 1) {
				Map.Entry<Character, Integer> freqEntry = frqUsedCharQ.remove();
				if (freqEntry.getValue() > 0)
					maxHeap.add(freqEntry);
			}

		}

		return sb.length() == str.length() ? sb.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aab", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
	}
}
