package strings;

import java.util.HashSet;
import java.util.Set;

class StringSegmentation {
	public static boolean canSegmentString(String s, Set<String> dictionary) {
		boolean result = false;

		for (int i = 0; i < s.length(); i++) {
			result = result || canSegmentStringHelper(s, dictionary, i);
		}

		return result;
	}

	public static boolean canSegmentStringHelper(String s, Set<String> dictionary, int i) {
		String word1 = s.substring(0, i + 1);

		String word2 = s.substring(i + 1, s.length());
		if (dictionary.contains(word1)) {
			if (dictionary.contains(word2) ||  canSegmentString(word2, dictionary) ) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		String s = new String();
		s = "hellonow";

		dictionary.add("hello");
		dictionary.add("hell");
		dictionary.add("on");
		dictionary.add("now");
		if (canSegmentString(s, dictionary)) {
			System.out.println("String Can be Segmented");
		} else {
			System.out.println("String Can NOT be Segmented");
		}
	}
}
