package binarysearch;

class ArrayReader {
	int[] arr;

	ArrayReader(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		if (index >= arr.length)
			return Integer.MAX_VALUE;
		return arr[index];
	}
}

class SearchInfiniteSortedArray {

	public static int search(ArrayReader reader, int key) {
		int low = 0, high = 0;
		int index = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			int currentIndex = (int) Math.pow(2, i);
			int valueAtCurrentIndex = reader.get(currentIndex);

			if (valueAtCurrentIndex == Integer.MAX_VALUE) {
				high = currentIndex;
				break;
			} else if (valueAtCurrentIndex == key) {
				return currentIndex;
			} else if (valueAtCurrentIndex < key) {
				low = currentIndex;
			} else {
				high = currentIndex;
				break;
			}

		}
		index = binarySearch(low, high, reader, key);
		return index;
	}

	public static int binarySearch(int start, int end, ArrayReader reader, int key) {

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int valueAtMid = reader.get(mid);

			if (valueAtMid == key) {
				return mid;
			} else if (valueAtMid < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		System.out.println(SearchInfiniteSortedArray.search(reader, 16));
		System.out.println(SearchInfiniteSortedArray.search(reader, 11));
		reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
		System.out.println(SearchInfiniteSortedArray.search(reader, 15));
		System.out.println(SearchInfiniteSortedArray.search(reader, 200));
	}
}