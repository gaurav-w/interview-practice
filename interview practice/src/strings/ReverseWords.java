package strings;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReverseWords {

	public static void reverseWords(char[] sentence) {
		ArrayList<String> words = new ArrayList<>();
		StringBuffer word = new StringBuffer();

		for (int i = 0; i < sentence.length; i++) {
			char c = sentence[i];
			if (c != ' ')
				word.append(c);
			else { // on space
				words.add(word.toString());
				word = new StringBuffer();

			}
		}
		if (word.length() > 0)
			words.add(word.toString()); // last one

		int c = 0;

		for (int i = words.size() - 1; i >= 0; i--) {
			for (int j = 0; j < words.get(i).length(); j++) {
				sentence[c] = words.get(i).charAt(j);

				c++;
			}
			if (i != 0) {
				sentence[c] = ' ';
				c++;
			}

		}
		// System.out.print(sentence[c]);
	}

	static char[] getArray(String t) {
		char[] s = new char[t.length()];
		int i = 0;
		for (; i < t.length(); ++i) {
			s[i] = t.charAt(i);
		}
		return s;
	}

	public static void main(String[] args) {
		char[] s = getArray("Hello World!");
		System.out.println(s);
		reverseWords(s);
		System.out.println(s);
	}
}
