package dp;

class SubsetSum {

	static boolean canPartition(int[] num, int sum) {
		boolean dp[][] = new boolean[num.length][sum + 1];

		for (int i = 0; i < num.length; i++)
			dp[i][0] = true;

		for (int i = 0; i < num.length; i++) {
			if (i == num[0])
				dp[0][i] = true;
		}

		for (int i = 1; i < num.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (dp[i - 1][j] == true || j == num[i])
					dp[i][j] = true;

				if (j - num[i] >= 0 && dp[i - 1][j - num[i]] == true)
					dp[i][j] = true;

			}
		}

		return dp[num.length - 1][sum];
	}

	public static void main(String[] args) {
		SubsetSum ss = new SubsetSum();
		int[] num = { 1, 2, 3, 7 };
		System.out.println(ss.canPartition(num, 6));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(ss.canPartition(num, 10));
		num = new int[] { 1, 3, 4, 8 };
		System.out.println(ss.canPartition(num, 6));
	}
}