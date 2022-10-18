package arrays;

import java.util.*;

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
};

class MinimumMeetingRooms {

	/*
	 * maintain minheap -> stores according to end time. all the items in minheap
	 * denote intersection
	 * 
	 * so max items in heap is no of meeting rooms needed
	 * 
	 * 1. sort the meetings 2. iterate through the meetings a. find the top most
	 * meeting in min heap b. if the start time of new meeting > end time of the
	 * meeting -> pop c. push the new meeting d. find size of minheap -> update max
	 */
	public static int findMinimumMeetingRooms(List<Meeting> meetings) {
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
		Collections.sort(meetings, (a, b) -> a.start - b.start);
		int minMeetingRooms = 1;

		for (int i = 0; i < meetings.size(); i++) {
			if (!minHeap.isEmpty()) {
				Meeting top = minHeap.peek();

				if (top.end <= meetings.get(i).start) { // no intersection
					minHeap.remove();
				}

				minHeap.add(meetings.get(i));
				minMeetingRooms = Math.max(minMeetingRooms, minHeap.size());
			} else {
				minHeap.add(meetings.get(i));
			}
		}

		return minMeetingRooms;
	}

	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 5));
				add(new Meeting(7, 9));
			}
		};
		int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(6, 7));
				add(new Meeting(2, 4));
				add(new Meeting(8, 12));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 3));
				add(new Meeting(3, 6));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);
	}
}
