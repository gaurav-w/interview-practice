package arrays;

import java.time.Instant;

class LeastCommonNumber {
	static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		int max = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length) {

			max = Math.max(arr1[i], arr2[j]);
			max = Math.max(arr3[k], max);

			while (arr1[i] < max && i < arr1.length)
				i++;

			if (i == arr1.length)
				break;

			while (arr2[j] < max && j < arr2.length)
				j++;

			if (j == arr2.length)
				break;

			while (arr3[k] < max && k < arr3.length)
				k++;

			if (k == arr3.length)
				break;

			if (arr1[i] == arr2[j] && arr2[j] == arr3[k])
				return arr1[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] v1 = new int[] { 6, 7, 10, 25, 30, 63, 64 };
		int[] v2 = new int[] { 0, 4, 5, 6, 7, 8, 50 };
		int[] v3 = new int[] { 1, 6, 10, 14 };

		Integer result = findLeastCommonNumber(v1, v2, v3);

		System.out.println("Least Common Number: " + result);
	}
}