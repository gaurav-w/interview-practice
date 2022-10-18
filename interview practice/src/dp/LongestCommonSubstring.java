package dp;

public class LongestCommonSubstring {
	public int findLCSLength(String s1, String s2) {
		return findLCSLengthRecursive(s1, s2, 0, 0, 0);
	}

	private int findLCSLengthRecursive(String s1, String s2, int i, int j, int count) {

		if (i >= s1.length() || j >= s2.length())
			return count;

		if (s1.charAt(i) == s2.charAt(j)) {
			count = findLCSLengthRecursive(s1, s2, i + 1, j + 1, count + 1);
		}

		int c1 = findLCSLengthRecursive(s1, s2, i, j + 1, 0);
		int c2 = findLCSLengthRecursive(s1, s2, i + 1, j, 0);

		return Math.max(c1, Math.max(count, c2));
	}

	public static void main(String[] args) {
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.findLCSLength("abdca", "cbda"));
		System.out.println(lcs.findLCSLength("passport", "ppsspt"));
	}

}
