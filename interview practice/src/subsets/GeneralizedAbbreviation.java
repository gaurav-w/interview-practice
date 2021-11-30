package subsets;

import java.util.*;

class GeneralizedAbbreviation {

	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		Queue<String> subsets = new LinkedList<>();
		subsets.add(word);

		for (int i = 0; i < word.length(); i++) {

			int n = subsets.size();
			for (int j = 0; j < n; j++) {

				String currentSet = subsets.poll();
				String newSet = transform(currentSet, i);
				subsets.add(currentSet);
				subsets.add(newSet);
			}

		}

		result.addAll(subsets);
		return result;
	}

	private static String transform(String word, int index) {
		StringBuffer sb = new StringBuffer();
		sb.append(word);

		if (word.length() > index + 1 && Character.isDigit(sb.charAt(index + 1))) {
			int no = sb.charAt(index + 1) - '0';
			++no;
			sb.replace(index, index + 2, String.valueOf(no));
		} else if (index - 1 >= 0 && Character.isDigit(sb.charAt(index - 1))) {
			int no = sb.charAt(index - 1) - '0';
			++no;
			sb.replace(index - 1, index + 1, String.valueOf(no));
		} else
			sb.replace(index, index + 1, String.valueOf(1));

		return sb.toString();
	}

	public static void main(String[] args) {
		List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
		System.out.println("Generalized abbreviation are: " + result);

		result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
		System.out.println("Generalized abbreviation are: " + result);
	}
}
