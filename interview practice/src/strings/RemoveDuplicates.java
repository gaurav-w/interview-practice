package strings;

import java.util.HashSet;

class RemoveDuplicates {
	static void removeDuplicates(char[] str) {

		HashSet<Character> set = new HashSet<>();
		int c = 0;
		for (int i = 0; i < str.length; i++) {
			if (!set.contains(str[i])) {
				set.add(str[i]);
				str[c] = str[i];
				c++;
			}
		}

		while (c < str.length - 1) {
			str[c] = ' ';
			c++;
		}
	}

	static char[] getArray(String t) {
		char[] s = new char[t.length() + 1];
		int i = 0;
		for (; i < t.length(); ++i) {
			s[i] = t.charAt(i);
		}
		s[i] = '\0';
		return s;
	}

	static void print(char[] s) {
		int i = 0;
		while (s[i] != '\0') {
			System.out.print(s[i]);
			++i;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		char[] input = getArray("dabbac");
		System.out.print("Before: ");
		System.out.println(input);
		RemoveDuplicates.removeDuplicates(input);
		System.out.print("After: ");
		print(input);
	}
}