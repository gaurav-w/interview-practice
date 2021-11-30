package KElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class TopKFrequentNumbers {

	// class NumFrequency {
	// int num;
	// int freq;

	// NumFrequency(int num, int freq){
	// this.num = num;
	// this.freq = freq;
	// }
	// }

	public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		List<Integer> topNumbers = new ArrayList<>(k);
		HashMap<Integer, Long> map = new HashMap<>();
		map = Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
		final Set<Map.Entry<Integer, Long>> entrySet = map.entrySet();

		PriorityQueue<Map.Entry<Integer, Long>> q = new PriorityQueue<Map.Entry<Integer, Long>>(
				(a, b) -> (b.getValue().intValue() - a.getValue().intValue()));

		for (Map.Entry<Integer, Long> entry : entrySet)
			q.add(entry);

		for (int i = 0; i < k; i++)
			topNumbers.add(q.poll().getKey());

		return topNumbers;
	}

	public static void main(String[] args) {
		List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);

		result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}
}
