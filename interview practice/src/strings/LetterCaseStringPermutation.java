package strings;

import java.util.*;

class LetterCaseStringPermutation {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		permutations.add(str);

		for (int ch = 0; ch < str.length(); ch++) {
			if (Character.isAlphabetic(str.charAt(ch))) {

				int size = permutations.size();

				for (int i = 0; i < size; i++) {
					String currentstr = permutations.get(i);
					char st[] = currentstr.toCharArray();
					if (Character.isLowerCase(st[ch]))
						st[ch] = Character.toUpperCase(st[ch]);
					else
						st[ch] = Character.toLowerCase(st[ch]);
					String newstr = new String(st);
					permutations.add(newstr);
				}
			}
		}

		return permutations;
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}
}
