package dp;

class CutRibbon {

	public int countRibbonPieces(int[] ribbonLengths, int total) {
		int dp[][] = new int[ribbonLengths.length][total + 1];

		for (int j = 1; j <= total; j++) {
			if ((j - ribbonLengths[0]) >= 0 && (j % ribbonLengths[0]) == 0)
				dp[0][j] = 1 + dp[0][j - ribbonLengths[0]];
		}

		for (int i = 1; i < ribbonLengths.length; i++) {
			for (int j = 1; j <= total; j++) {
				int include = 0;
				int exclude = 0;

				if (j - ribbonLengths[i] >= 0 && dp[i][j - ribbonLengths[i]] != 0)
					include = 1 + dp[i][j - ribbonLengths[i]];

				exclude = dp[i - 1][j];
				dp[i][j] = exclude;

				dp[i][j] = Math.max(include, dp[i][j]);
			}
		}

		return dp[ribbonLengths.length - 1][total];
	}

	public static void main(String[] args) {
		CutRibbon cr = new CutRibbon();
		int[] ribbonLengths = { 2, 3, 5 };
		System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
		ribbonLengths = new int[] { 2, 3 };
		System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
		ribbonLengths = new int[] { 3, 5, 7 };
		System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
		ribbonLengths = new int[] { 3, 5 };
		System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
	}
}