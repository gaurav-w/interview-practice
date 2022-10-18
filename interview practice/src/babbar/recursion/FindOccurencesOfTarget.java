package babbar.recursion;

import java.util.ArrayList;

/**
 * Find first,last, all occurences of a number using recursion
 * 
 * @author gaura
 *
 */
public class FindOccurencesOfTarget {
	public static void main(String[] args) {
		int arr[] = { 45, 23, 65, 31, 64, 31 };
		System.out.println(findFirstIndexOfTarget(arr, 0, 31));
		System.out.println(findLastIndexOfTarget(arr, arr.length - 1, 31));

		ArrayList<Integer> indexes = new ArrayList<Integer>();
		findAllOccurences(arr, 0, 31, indexes);
		System.out.println(indexes);

	}

	static int findFirstIndexOfTarget(int arr[], int index, int target) {

		if (arr.length == index)
			return -1;

		if (arr[index] == target)
			return index;
		else
			return findFirstIndexOfTarget(arr, index + 1, target);
	}

	/*
	 * Same code as above only change is subtraction of index
	 */
	static int findLastIndexOfTarget(int arr[], int index, int target) {

		if (arr.length == index)
			return -1;

		if (arr[index] == target)
			return index;
		else
			return findFirstIndexOfTarget(arr, index - 1, target);
	}

	/*
	 * Start from 0 index
	 */
//	static int findLastIndexOfTarget2(int arr[], int index, int target) {
//		if (arr.length == index)
//			return -1;
//
//		if (arr[index] == target) {
//			Math.max(index, findLastIndexOfTarget2(arr, index + 1, target));
//		} else
//			return findFirstIndexOfTarget(arr, index + 1, target);
//	}

	static void findAllOccurences(int arr[], int index, int target, ArrayList<Integer> indexes) {
		if (arr.length == index)
			return;

		if (arr[index] == target)
			indexes.add(index);

		findAllOccurences(arr, index + 1, target, indexes);
	}

}
