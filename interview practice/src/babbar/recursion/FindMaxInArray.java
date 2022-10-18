package babbar.recursion;

/**
 * Find max in an array using recursion
 * 
 * @author gaura
 *
 */
public class FindMaxInArray {

	public static void main(String[] args) {
		int arr[] = { 45, 23, 65, 21, 64, 2 };
		System.out.println(getMax(arr, 0));
	}

	static int getMax(int arr[], int index) {

		if (arr.length == index)
			return Integer.MIN_VALUE;

		int max1 = arr[index];
		int max2 = getMax(arr, index + 1);

		return Math.max(max1, max2);
	}

}
