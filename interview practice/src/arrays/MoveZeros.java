package arrays;

import java.util.Arrays;

class MoveZeros {
	static void moveZerosToLeft(int[] A) {
		int n = A.length;
		
		for (int i = n - 1; i >= 0; i--) {

			if (A[i] == 0) {
				for (int j = i - 1; j >= 0; j--) {

					if (A[j] != 0) {
						A[i] = A[j];
						A[j] = 0;
						break;
					}

				}
			}

		}

	}

	public static void main(String[] args) {
		int[] v = new int[] { 1, 10, 20, 0, 59, 63, 0, 88, 0 };
		System.out.println("Original Array: " + Arrays.toString(v));

		moveZerosToLeft(v);

		System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
	}
}