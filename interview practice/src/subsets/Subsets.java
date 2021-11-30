package subsets;

import java.util.ArrayList;
import java.util.List;

class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

	
		
		subsets.add(new ArrayList<>() ); //empty set
		
		for (int currentElement: nums) {
			int n = subsets.size();
			for (int subsetNo = 0; subsetNo < n; subsetNo++) {
				ArrayList<Integer> tempList = new ArrayList<>();

			
				tempList.addAll( subsets.get(subsetNo) );
				tempList.add(currentElement);
				subsets.add(tempList);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = Subsets.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}