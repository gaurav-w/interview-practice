package subsets;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
	// 1. n = open and n = close - add to result
	// 2. a. open < n add open
//	     b. open < close add close

	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		// TODO: Write your code here
		char[] arr = new char[2 * num];
		generateValidParenthesesHelper(num, 0, 0, result, 0, arr);
		return result;
	}

	public static void generateValidParenthesesHelper(int num, int open, int close, List<String> result, int index,
			char[] arr) {

		if (open == num && close == num) {
			result.add(String.valueOf(arr));
		}

		if (open < num) {
			arr[index] = '(';
			generateValidParenthesesHelper(num, open + 1, close, result, index + 1, arr);
		}

		if (open > close) {
			arr[index] = ')';
			generateValidParenthesesHelper(num, open, close + 1, result, index + 1, arr);
		}

	}

	public static void main(String[] args) {
		List<String> result = GenerateParentheses.generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

//		result = GenerateParentheses.generateValidParentheses(3);
//		System.out.println("All combinations of balanced parentheses are: " + result);
	}
}
