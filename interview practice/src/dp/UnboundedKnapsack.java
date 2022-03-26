package dp;

class UnboundedKnapsack {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		int map[][] = new int[profits.length][capacity + 1];
		int result = solveKnapsackMemoization(profits, weights, capacity, 0, map);
		return result;
	}

	public int solveKnapsackMemoization(int[] profits, int[] weights, int capacity, int index, int map[][]) {

		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || index >= weights.length)
			return 0;

		if (map[index][capacity] != 0)
			return map[index][capacity];

		int include = 0;

		if (capacity - weights[index] >= 0)
			include = profits[index]
					+ solveKnapsackMemoization(profits, weights, capacity - weights[index], index, map);
		int exclude = solveKnapsackMemoization(profits, weights, capacity, index + 1, map);

		map[index][capacity] = Math.max(include, exclude);

		return map[index][capacity];
	}

	public static void main(String[] args) {
		UnboundedKnapsack ks = new UnboundedKnapsack();
		int[] profits = { 15, 50, 60, 90 };
		int[] weights = { 1, 3, 4, 5 };
		int maxProfit = ks.solveKnapsack(profits, weights, 8);
		System.out.println(maxProfit);
	}
}
