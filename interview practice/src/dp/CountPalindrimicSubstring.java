package dp;

class CountPalindrimicSubstring {

	public int findCPS(String st) {
		// return findCPSRecursive(st, 0, st.length() - 1);
		return countPSRecursive(st, 0, st.length() - 1);
	}

	private int countPSRecursive(String st, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return 0;

		// every string with one character is a palindrome
		if (startIndex == endIndex)
			return 1;

		int c0 = 0;
		if (isPalindrome(st, startIndex, endIndex))
			c0 = 1;

		// count all palindromes from "startIndex+1" to "endIndex"
		int c1 = countPSRecursive(st, startIndex + 1, endIndex);
		// count all palindromes from "startIndex" to "endIndex-1"
		int c2 = countPSRecursive(st, startIndex, endIndex - 1);
		// because of the above two recursive calls, since we have counted twice all
		// palindromes from "startIndex+1" to "endIndex-1", let's subtract one count
		int c4 = countPSRecursive(st, startIndex + 1, endIndex - 1);

		return c0 + c1 + c2 - c4;
	}

	private boolean isPalindrome(String st, int x, int y) {
		int a = x;
		int b = y;
		while (x <= y) {
			if (st.charAt(x++) != st.charAt(y--))
				return false;
		}
		System.out.println(st.substring(a, b  + 1));
		return true;
	}

	public int findCPSRecursive(String st, int start, int end) {

		if (start == end)
			return 1;

		if (start > end)
			return 0;

		int c0 = 0;
		if (st.charAt(start) == st.charAt(end)) {
			if (findCPSRecursive(st, start + 1, end - 1) == 1)
				c0 = 1;
		}

		int c1 = findCPSRecursive(st, start, end - 1);
		int c2 = findCPSRecursive(st, start + 1, end);

		return c0 + c1 + c2;

	}

	public static void main(String[] args) {
		CountPalindrimicSubstring cps = new CountPalindrimicSubstring();
		System.out.println(cps.findCPS("aba"));
		//System.out.println(cps.findCPS("cdpdd"));
		//System.out.println(cps.findCPS("pqr"));
	}
}