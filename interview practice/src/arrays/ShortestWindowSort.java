package arrays;

class ShortestWindowSort {

	public static int sort(int[] arr) {
		if (arr == null || arr.length == 1)
			return -1;

		int winStart = -1;
		int winEnd = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				winStart = i;
				break;
			}

		}

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				winEnd = i;
				break;
			}
		}

		if (winStart == -1 && winEnd == -1) // sorted
			return 0;

		if (winStart == 0 && winEnd == arr.length - 1) // reverse sorted
			return arr.length;

		// find min, max in the window to extend the windows
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = winStart; i <= winEnd; i++) {
			min = Math.min(min, arr[i]);
			max = Math.min(max, arr[i]);
		}

		// extend start
		for (int i = winStart - 1; i >= 0; i--) {
			if (arr[i] > min)
				winStart--;
			else
				break;
		}

		// extend end
		for (int i = winEnd + 1; i < arr.length; i++) {
			if (arr[i] < max)
				winEnd++;
			else
				break;
		}

		return winEnd - winStart + 1;

	}

	public static void main(String[] args) {
		System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
	}
}
