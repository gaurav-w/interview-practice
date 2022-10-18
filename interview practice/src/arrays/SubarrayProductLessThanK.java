package arrays;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {
	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int prod = 1;
		int left = 0;

		for (int r = 0; r < arr.length; r++) {
			prod = prod * arr[r];

			while (prod >= target) {
				prod = prod / arr[left];
				left++;
			}

			ArrayList<Integer> list = new ArrayList<Integer>();

			// generate the subsets
			for (int i = r; i >= left; i--) {
				list.add(arr[i]);
				result.add(new ArrayList<>(list));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
	}
}
