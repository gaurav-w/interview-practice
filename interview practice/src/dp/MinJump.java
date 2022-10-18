package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinJump {

	public static void main(String[] args) {
		int a[] = { 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0,
				47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18,
				33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23,
				22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };

		ArrayList<Integer> A = (ArrayList) Arrays.stream(a).boxed().collect(Collectors.toList());
		;

		System.out.println(jump(A));

		MinJump aj = new MinJump();
		int[] jumps = { 2, 1, 1, 1, 4 };
		System.out.println(aj.countMinJumps(jumps));
		jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
		System.out.println(aj.countMinJumps(jumps));
	}

	public int countMinJumps(int[] jumps) {
		int dp[] = new int[jumps.length];
		return countMinJumpsRecursive(jumps, 0, dp);
	}

	public int countMinJumpsRecursive(int[] jumps, int index, int dp[]) {

		if (index >= jumps.length)
			return Integer.MAX_VALUE;

		if (jumps[index] == 0)
			return Integer.MAX_VALUE;

		if (index == jumps.length - 1)
			return 0;

		if (dp[index] != 0)
			return dp[index];

		int start = index + 1;
		int end = index + jumps[index];
		int total = Integer.MAX_VALUE;

		for (int i = start; i < jumps.length && i <= end; i++) {
			int minJump = countMinJumpsRecursive(jumps, i, dp);
			if (minJump != Integer.MAX_VALUE)
				total = Math.min(total, 1 + minJump);
		}
		dp[index] = total;
		return total;
	}

	public static int jump(ArrayList<Integer> A) {

		int res[] = new int[A.size()];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;

		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j <= i + A.get(i); j++) {
				if (j < res.length) {
					res[j] = Math.min(res[j], res[i] + 1);
				}
			}
		}

		return res[A.size() - 1] == Integer.MAX_VALUE ? -1 : res[A.size() - 1];
	}
}
