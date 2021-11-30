package binarysearch;

class SearchRotatedArray {

	public static int search(int[] arr, int key) {
		if (arr[0] == key)
			return 0;
		if (arr[arr.length - 1] == key)
			return arr.length - 1;

		int pt = getRotatedPoint(arr);

		int res = binarySearch(0, pt, arr, key);

		if (res == -1)
			res = binarySearch(pt, arr.length - 1, arr, key);

		return res;
	}

	public static int binarySearch(int start, int end, int arr[], int key) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key == arr[mid]) {
				return mid;
			} else if (key < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	public static int getRotatedPoint(int[] arr) {
		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (mid > 0 && arr[mid] < arr[mid - 1])
				end = mid - 1;
			else
				start = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
		System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
		System.out.println(SearchRotatedArray.search(new int[] { 3, 7, 3, 3, 3 }, 7));
	}
}
