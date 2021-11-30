package binarysearch;

class CeilingOfANumber {

	public static int searchCeilingOfANumber(int[] arr, int key) {

		int start = 0, end = arr.length - 1;
		int closest = -1;
		int ceiling = Integer.MAX_VALUE;

		while (start <= end) {
			int middle = start + ((end - start) / 2);

			if (arr[middle] == key)
				return middle;
			else if (arr[middle] > key) {
				end = middle - 1;
				if (Math.min(arr[middle] - key, ceiling) == arr[middle] - key) {
					ceiling = arr[middle] - key;
					closest = middle;
				}
			} else {
				start = middle + 1;

			}
		}

		return closest;
	}

	public static void main(String[] args) {
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}
}