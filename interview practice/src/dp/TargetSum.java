package dp;

import java.util.HashMap;

class TargetSum {
	HashMap<String, Integer> map = new HashMap<>();

	public int findTargetSubsets(int[] num, int s) {

		if (num == null || num.length == 0)
			return 0;
		int ans = findTargetSubsetsHelper(num, s, 0, 0);
		map.clear();
		return ans;
	}

	public int findTargetSubsetsHelper(int[] num, int s, int sum, int index) {

//		if (num.length == index && sum == s)
//			return 1;
//
//		if (index >= num.length)
//			return 0;
//
//		int plus = findTargetSubsetsHelper(num, s, sum + num[index], index + 1);
//		int minus = findTargetSubsetsHelper(num, s, sum - num[index], index + 1);
//
//		return plus + minus;

		if (map.containsKey(sum + "," + index))
			return map.get(sum + "," + index);

		if (num.length == index && sum == s)
			return 1;

		if (index >= num.length)
			return 0;

		int plus = findTargetSubsetsHelper(num, s, sum + num[index], index + 1);
		int minus = findTargetSubsetsHelper(num, s, sum - num[index], index + 1);

		map.put(sum + "," + index, plus + minus);
		return plus + minus;

	}

//	public int findTargetSubsetsHelper2(int[] num, int s) {
//
//		int dp[][] = new int[num.length + 1][s + 1];
//		
//		
//		if (num.length == index && sum == s)
//			return 1;
//
//		if (index >= num.length)
//			return 0;
//
//		int plus = findTargetSubsetsHelper(num, s, sum + num[index], index + 1);
//		int minus = findTargetSubsetsHelper(num, s, sum - num[index], index + 1);
//
//		return plus + minus;
//
//	}

	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		int[] num = { 1, 1, 2, 3 };
		System.out.println(ts.findTargetSubsets(num, 1));
		num = new int[] { 1, 2, 7, 1 };
		System.out.println(ts.findTargetSubsets(num, 9));
	}
}
