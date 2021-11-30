package binarysearch;

class RotationCountOfRotatedArray {

	public static int countRotations(int[] arr) {
		int pt = getRotatedPoint(arr);

		return pt + 1; // 1 is no of rotations
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
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 3, 3, 7, 3 }));
	}
}
