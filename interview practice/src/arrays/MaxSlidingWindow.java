package arrays;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class MaxSlidingWindow {
	public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		int start = 0, end = 0;

		for (int i = 0; i < windowSize; i++) {
			maxHeap.add(arr[i]);
			end++;
		}

		for (int i = 0; i <= arr.length - windowSize; i++) {
			int max = maxHeap.peek();
			result.add(max);

			int toRemove = arr[start];
			maxHeap.remove(toRemove);
			start++;
			end++;
		}

		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {-4, 2, 3, 5};
		ArrayDeque<Integer> result = findMaxSlidingWindow(arr, 3);
		result.stream().forEach(s->System.out.println(s));
	}
}