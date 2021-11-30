package binarysearch;

class SearchBitonicArray {

	public static int search(int[] arr, int key) {

		if (arr[arr.length - 1] == key)
			return arr.length - 1;

		if (arr[0] == key)
			return 0;

		int changePointArr = changePoint(arr);
		int res = -1;

		if (arr[0] <= key && arr[changePointArr] >= key)
			res = binarySearch(0, changePointArr, arr, key, true);
		if (arr[changePointArr] >= key && arr[arr.length - 1] <= key)
			res = binarySearch(changePointArr, arr.length - 1, arr, key, false);

		return res;
	}

	public static int changePoint(int[] arr) {

		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1])
				return mid;
			else if (arr[mid] < arr[mid + 1])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static int binarySearch(int start, int end, int[] arr, int key, boolean increasing) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key && increasing) {
				start = mid + 1;
			} else if (arr[mid] > key && increasing) {
				end = mid - 1;
			} else if (arr[mid] < key && !increasing) {
				end = mid - 1;
			} else if (arr[mid] > key && !increasing) {
				start = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
		System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
		System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
		System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
	}
}
