package dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	private int findLBSLength(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int increasingMax = LIS(nums, 0, i);
			int decreasingMax = LDS(nums, i + 1, nums.length - 1);
			max = Math.max(max, increasingMax + decreasingMax);
		}

		return max;
	}

	private int LIS(int nums[], int start, int end) {
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 0;

		for (int i = start; i <= end; i++) {
			for (int j = start; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	private int LDS(int nums[], int start, int end) {
		int dp[] = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 0;

		for (int i = start; i <= end; i++) {
			for (int j = start; j < i; j++) {
				if (nums[i] < nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(lbs.findLBSLength(nums));
		 nums = new int[] { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
		 System.out.println(lbs.findLBSLength(nums));
	}
}
