package arrays;

import java.util.*;

public class TripletWithSmallerSum {

	public static int searchTriplets(int[] arr, int target) {
		List<List<Integer>> list = new ArrayList<>();
				
		Arrays.sort(arr);
		int count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			int high = arr.length - 1;
			int low = i + 1;

			while (high > low) {
				int sum = arr[i] + arr[low] + arr[high];

				if (sum >= target) {
					high--;
				} else {
					
					for(int start=high; start>low; start--) {
						ArrayList<Integer> mylist = new ArrayList<Integer>();
						mylist.add(arr[i]);
						mylist.add(arr[low]);
						mylist.add(arr[start]);
						list.add(mylist);
					}
					
					count = count + high - low;
					low++;
				}
			}

		}
		
		for(List<Integer> l : list) {
			System.out.println( l );
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
	}
}