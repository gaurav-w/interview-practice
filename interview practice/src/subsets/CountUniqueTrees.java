package subsets;

class CountUniqueTrees {

	int c[];

	public int countTrees(int n) {
		// TODO: Write your code here
		c = new int[n + 2];

		c[0] = 1;
		c[1] = 1;
		int res = getCatalanNo(n, c);
		return res;
	}

//cn+1 = sum of ci cn-1
	public int getCatalanNo(int n, int arr[]) {
		int sum = 0;

		if (n <= 1)
			return c[n];
		else {
			for (int i = 2; i <= n + 1; i++) {
				int a = getCatalanNo(i - 2, arr);
				int b = getCatalanNo(n - i + 1, arr);
				sum = sum + a * b;
				arr[i] = sum;
			}
		}
		return sum;
	}

//c3 = c0c2 + c1c1 + c2c0
	public static void main(String[] args) {
		CountUniqueTrees ct = new CountUniqueTrees();
		int count = ct.countTrees(4);
		System.out.print("Total trees: " + count);
	}
}
