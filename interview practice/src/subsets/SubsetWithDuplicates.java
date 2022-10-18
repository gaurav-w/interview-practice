package subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDuplicates {
	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		int changedStart = 0;

		for (int numIndex = 0; numIndex < nums.length; numIndex++) {
			int size = result.size();

			int start = 0;

			if (numIndex - 1 >= 0 && nums[numIndex] == nums[numIndex - 1])
				start = changedStart;

			for (int setIndex = start; setIndex < size; setIndex++) {
				List<Integer> currentSet = result.get(setIndex);
				ArrayList<Integer> newSet = new ArrayList(currentSet);
				newSet.add(nums[numIndex]);
				result.add(newSet);
			}

			changedStart = size;

		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}
