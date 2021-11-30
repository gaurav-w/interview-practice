package heaps;

import java.util.*;

class MaximumDistinctElements {

	/**
	 * This function needs to 1. create frequency map / sort 2. push all Entry with
	 * value > 1 into Heap - MinHeap 3. calc distinct = size of map - heap 4.
	 * iterate over heap && currentK>=0 a. if currentK - element value + 1 >= 0 1
	 * remove element from heap 2 distinct++ 3 currentK = currentK - element value +
	 * 1; 4. if currentK>0 distinct - currentK return distinct;
	 **/
	public static int findMaximumDistinctElements(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		int distinct = 0;

		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

		for (Map.Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > 1)
				q.add(entry);
			else
				distinct++;
		}

		int iter = q.size();

		while (iter > 0 && k > 0) {

			k = k - q.peek().getValue() + 1;
			if (k > 0) {
				q.poll();
				distinct++;
			} else
				break;
			iter--;
		}

		if (k > 0)
			distinct -= k;

		return distinct;

	}

	public static void main(String[] args) {
		int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);
	}
}