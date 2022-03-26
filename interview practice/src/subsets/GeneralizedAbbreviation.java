package subsets;

import java.util.*;

class GeneralizedAbbreviation {

	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		result.add(word);

		for (int i = 0; i < word.length(); i++) {

			int n = result.size();
			for (int j = 0; j < n; j++) {

				String currentSet = result.get(j);
				String newSet = transform(currentSet, i);
				result.add(newSet);
			}

		}

		return result;
	}

	private static String transform(String word, int index) {
		StringBuffer sb = new StringBuffer();
		sb.append(word);

//		int count = 0;
//		for (int i = 0; i < word.length() && i < index; i++) {
//			if (Character.isDigit(word.charAt(i)) && word.charAt(i) != '1') {
//				count = count + word.charAt(i) - '0';
//			}
//		}

//		index = index - count + 1;

		if (word.length() > index + 1 && Character.isDigit(sb.charAt(index + 1))) {
			int no = sb.charAt(index + 1) - '0';
			++no;
			sb.replace(index, index + 2, String.valueOf(no));
		}

		if (index - 1 >= 0 && Character.isDigit(sb.charAt(index - 1))) {
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
