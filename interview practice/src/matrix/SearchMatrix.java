package matrix;

class SearchMatrix {
	public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {

		if (numberOfRows == 0)
			return false;

		if (numberOfColumns == 0)
			return false;

		int low = 0, high = numberOfRows - 1;
		int row = 0;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (matrix[mid][0] == target)
				return true;
			else if (matrix[mid][0] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}

		row = mid;
		low = 0;
		high = numberOfColumns - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (matrix[row][mid] == target)
				return true;
			else if (matrix[row][mid] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}

		return false;
	}

	public static void main(String args[]) {
		int[][] matrix = { { 10, 11, 12, 13 }, { 14, 15, 16, 17 }, { 27, 29, 30, 31 }, { 32, 33, 39, 50 } };

		// Example 1
		Object x = findKey(matrix, 4, 4, 80);
		System.out.println("Search for 80 returned: " + x);

		// Example 2
		x = findKey(matrix, 4, 4, 15);
		System.out.println("Search for 15 returned: " + x);
	}
}