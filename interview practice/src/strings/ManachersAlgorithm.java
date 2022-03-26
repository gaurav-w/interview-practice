package strings;

public class ManachersAlgorithm {
	public static void main(String[] args) {
		ManachersAlgorithm lps = new ManachersAlgorithm();
		System.out.println(lps.findLPSLength("abdbca"));
		System.out.println(lps.findLPSLength("cdpdd"));
		System.out.println(lps.findLPSLength("pqr"));
	}

	private int findLPSLength(String string) {
		int result = 0;
		
		if(string.length()<0)
			return 0;
		
		for (int i = 0; i < string.length() - 1; i++) {
			result = Math.max(result, enlargePalindrome(string, i, i));
			result = Math.max(result, enlargePalindrome(string, i, i + 1));
		}

		return result;

	}

	private int enlargePalindrome(String str, int left, int right) {
		int result = 0;
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		result = right - left + 1 - 2;
		return result;
	}
}
