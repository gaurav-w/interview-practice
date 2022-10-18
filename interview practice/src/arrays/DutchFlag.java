package arrays;

import java.util.Arrays;

class DutchFlag {

	static void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	public static void sort(int[] arr) {

		int low = 0, high = arr.length - 1;
		int mid = 0;

		while (mid <= high) {

			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1)
				mid++;
			else { // case of 2
				swap(arr, mid, high);
				high--;
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		DutchFlag.sort(arr);

		System.out.print(Arrays.toString(arr));

		System.out.println();

		arr = new int[] { 2, 2, 0, 1, 2, 0 };
		DutchFlag.sort(arr);
		System.out.print(Arrays.toString(arr));
	}
}
