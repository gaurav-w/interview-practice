package stacks;

import java.util.Arrays;

public class NextGreaterChallenge {
	public static int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack(arr.length);
		// stack.push(-1);

		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.top() == null) {
				result[i] = -1;
			} else {

				while (!stack.isEmpty() && stack.top() <= arr[i]) {
					stack.pop();
				}

				if (!stack.isEmpty())
					result[i] = stack.top();
				else
					result[i] = -1;

			}
			stack.push(arr[i]);
			// System.out.println( result[i] );
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 6, 3, 2, 8, 1, 11 };
		System.out.println(Arrays.toString(arr));
		int result[] = nextGreaterElement(arr);
		System.out.println(Arrays.toString(result));
	}
}