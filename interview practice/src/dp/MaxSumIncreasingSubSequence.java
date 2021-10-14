package dp;

public class MaxSumIncreasingSubSequence {
    // Driver code
    public static void main(String args[]) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum " +
                "increasing subsequence is " +
                maxSumIS(arr, n));
    }

    private static int maxSumIS(int[] arr, int n) {
        return maxSum(arr, 0, Integer.MIN_VALUE);

    }

    static int maxSum(int[] arr, int n, int prev) {

        if (n == arr.length)
            return 0;

        int exclude = maxSum(arr, n + 1, prev);
        int include = 0;
        if (prev < arr[n]) {
            include = arr[n] + maxSum(arr, n + 1, arr[n]);
        }

        return Math.max(exclude, include);
    }
}
