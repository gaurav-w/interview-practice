package heaps;

import java.util.*;

class SlidingWindowMedian {
	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));

		// loop through the array to end - if size greater than 3 remove 1st element
		// calculate median using two heaps method
		int count = 0;
		int size = 0;

		for (int i = 0; i < nums.length; i++) {
			int element = nums[i];

			if (minHeap.isEmpty())
				minHeap.add(element);
			else if (maxHeap.size() > 0 && maxHeap.peek() >= element)// one element more
				maxHeap.add(element);
			else
				minHeap.add(element);

			balanceHeaps(maxHeap, minHeap);

			size = maxHeap.size() + minHeap.size();

			// calculate median & remove element
			if (i - k + 1 >= 0) {

				if (maxHeap.size() == minHeap.size())
					result[count] = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
				else {
					if (maxHeap.size() > minHeap.size())
						result[count] = maxHeap.peek();
					else
						result[count] = minHeap.peek();
				}
				int prevElement = nums[i - k + 1];
				if (maxHeap.contains(prevElement))
					maxHeap.remove(prevElement);
				if (minHeap.contains(prevElement))
					minHeap.remove(prevElement);

				count++;
			}

		}
		return result;
	}

	public void balanceHeaps(PriorityQueue<Integer> h1, PriorityQueue<Integer> h2) {
		if (h1.size() > h2.size() + 1) {
			h2.add(h1.poll());
		} else if (h2.size() > h1.size() + 1) {
			h1.add(h2.poll());
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		double[] result = null;// slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
//		System.out.print("Sliding window medians are: ");
//		for (double num : result)
//			System.out.print(num + " ");
//		System.out.println();

		slidingWindowMedian = new SlidingWindowMedian();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

}