package KElements;

import java.util.*;

class Element {
	int pos1;
	int pos2;

	Element(int p1, int p2) {
		this.pos1 = p1;
		this.pos2 = p2;
	}
}

class LargestPairs {

	public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		PriorityQueue<Element> minHeap = new PriorityQueue<>(
				(a, b) -> (nums1[a.pos1] + nums2[a.pos2]) - (nums1[b.pos1] + nums2[b.pos2]));

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {

				Element e = new Element(i, j);
				int current = nums1[i] + nums2[j];

				if (minHeap.size() < k)
					minHeap.add(e);
				else {
					int heapElement = nums1[minHeap.peek().pos1] + nums2[minHeap.peek().pos2];
					if (current > heapElement) {
						minHeap.add(e);
						minHeap.remove();
					}
				}

			}
		}

		for (int i = 0; i < minHeap.size(); i++) {
			Element e = minHeap.remove();
			result.add(new int[] { nums1[e.pos1], nums2[e.pos2] });
		}

		return result;
	}

	public static void main(String[] args) {
		int[] l1 = new int[] { 9, 8, 2 };
		int[] l2 = new int[] { 6, 3, 1 };
		List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
		System.out.print("Pairs with largest sum are: ");
		for (int[] pair : result)
			System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
	}
}
