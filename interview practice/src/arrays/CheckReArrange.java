package arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class CheckReArrange {

	public static void reArrange(int[] arr) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {

			if (arr[start] <= 0)
				start++;

			if (arr[end] > 0)
				end--;

			if (arr[start] > 0 && arr[end] < 0 && start <= end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;

			}
		}
	}
	
	

	public static void main(String[] args) {
		int ar[] = {10,-1,20,4,5,-9,-6};
		CheckReArrange.reArrange(ar);
		Arrays.stream(ar).forEach(s -> System.out.print(s +" " ) );

	}

}
