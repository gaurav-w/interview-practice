package dp;

public class LongestRepeatingSubSequence {

	public int findLRSLength(String str) {

		return findLRSLengthHelper(str, 0, 0);
	}

	public int findLRSLengthHelper(String str, int i1, int i2) {
//		if (i1 != i2)
//			System.out.println("f ( " + i1 + " , " + i2 + " )");
		if ( i1 >= str.length() || i2 >= str.length())
			return 0;

		int c0 = 0;
		if (i1!=i2  && str.charAt(i1) == str.charAt(i2)) {
			c0 = 1 + findLRSLengthHelper(str, i1 + 1, i2 + 1);
		}

		int c1 = findLRSLengthHelper(str, i1 + 1, i2);
		int c2 = findLRSLengthHelper(str, i1, i2 + 1);

		return Math.max(c0, Math.max(c1, c2));
	}

	public static void main(String[] args) {
		LongestRepeatingSubSequence lrs = new LongestRepeatingSubSequence();
		// System.out.println(lrs.findLRSLength("tomorrow"));
		// System.out.println(lrs.findLRSLength("aabdbcec"));
		System.out.println(lrs.findLRSLength("fmff"));
	}

}
