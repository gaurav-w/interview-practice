package binarysearch;

class BinarySearch {

	public static int search(int[] arr, int key) {

		boolean isAscending = arr[0] < arr[arr.length - 1] ? true : false;
		int n = arr.length;

		if (isAscending) {
			int start = 0;
			int end = n - 1;

			while (start <= end) {
				int middle = start + ((end - start) / 2);

				if (arr[middle] == key)
					return middle;
				else if (arr[middle] < key)
					start = middle + 1;
				else
					end = middle - 1;
			}

		} else {
			int start = 0;
			int end = n - 1;

			while (start <= end) {
				int middle = start + ((end - start) / 2);

				if (arr[middle] == key)
					return middle;
				else if (arr[middle] > key)
					start = middle + 1;
				else
					end = middle - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
		System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
		System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
		System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
	}
}