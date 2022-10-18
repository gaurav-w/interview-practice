package dp;

class CoinChange {

	public int countChange(int[] denominations, int total) {
		int dp[][] = new int[denominations.length][total + 1];

		for (int i = 0; i < denominations.length; i++) {
			dp[i][0] = 1;
		}

		// for(int j=1; j<=total; j++){
		// if( j >= denominations[0] && j%denominations[0]==0 )
		// dp[0][j] = 1 ;
		// }

		for (int i = 0; i < denominations.length; i++) {
			for (int j = 1; j <= total; j++) {

				int include = 0;
				int exclude = 0;

				if (j - denominations[i] >= 0)
					include = dp[i][j - denominations[i]];

				if (i - 1 >= 0)
					exclude = dp[i - 1][j];

				dp[i][j] = include + exclude;
			}

		}

		return dp[denominations.length - 1][total];
	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] denominations = { 1, 2, 3 };
		System.out.println(cc.countChange(denominations, 5));
	}
}