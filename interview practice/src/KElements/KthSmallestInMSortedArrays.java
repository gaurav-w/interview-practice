package KElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Element1 {
	Integer value;
	Integer position;
	Integer listNo;
}

class KthSmallestInMSortedArrays {

	//works well if lists < k - K * log M
//	public static int findKthSmallest(List<Integer[]> lists, int k) {
//		PriorityQueue<Element1> minHeap = new PriorityQueue<>((a, b) -> (a.value - b.value));
//
//		for (int i = 0; i < lists.size(); i++) {
//			for (int j = 0; j < 1; j++) { // insert just 1st element of every list
//
//				Element1 element = new Element1();
//				element.value = lists.get(i)[j];
//				element.position = j;
//				element.listNo = i;
//
//				minHeap.add(element);
//			}
//
//		}
//
//		while (!minHeap.isEmpty()) {
//			Element1 popped = minHeap.remove();
//			k--;
//
//			if (k == 0)
//				return popped.value;
//
//			if (lists.get(popped.listNo).length > popped.position + 1) {
//				Element1 nextElement = new Element1();
//				nextElement.value = lists.get(popped.listNo)[popped.position + 1];
//				nextElement.position = popped.position + 1;
//				nextElement.listNo = popped.listNo;
//				minHeap.add(nextElement);
//			}
//
//		}
//
//		return -1;
//	}

//works well when lists are > M Log K
	public static int findKthSmallest(List<Integer[]> lists, int k) {
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> (b - a));

		for (int i = 0; i < lists.size(); i++) {
			for (int j = 0; j < lists.get(i).length; j++) {

				int element = lists.get(i)[j];

				if (!maxQ.isEmpty() && maxQ.peek() > element) {
					maxQ.add(element);
				} else {
					maxQ.add(element);
				}

				if (maxQ.size() > k) {
					maxQ.poll();
				}
			}
		}

		return maxQ.poll();
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}
