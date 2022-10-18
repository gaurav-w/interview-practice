package dp;

class MinCoinChange {

	public int countChange(int[] denominations, int total) {

		int dp[][] = new int[denominations.length][total + 1];

		for (int j = 1; j <= total; j++) {
			if (j - denominations[0] >= 0 && (j % denominations[0]) == 0)
				dp[0][j] = 1 + dp[0][j - denominations[0]];
		}

		for (int i = 1; i < denominations.length; i++) {
			for (int j = 1; j <= total; j++) {

				int include = 0;
				int exclude = 0;

				if (j - denominations[i] >= 0)
					include = 1 + dp[i][j - denominations[i]];

				exclude = dp[i - 1][j];

				dp[i][j] = exclude;

				if (j - denominations[i] >= 0)
					dp[i][j] = Math.min(dp[i][j], include);

			}
		}

		return dp[denominations.length - 1][total];
	}

	public static void main(String[] args) {
		MinCoinChange cc = new MinCoinChange();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange(denominations, 5));
		System.out.println(cc.countChange(denominations, 11));
		System.out.println(cc.countChange(denominations, 7));
		denominations = new int[] { 3, 5 };
		System.out.println(cc.countChange(denominations, 7));
	}
}
