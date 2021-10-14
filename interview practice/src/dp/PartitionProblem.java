package dp;

import java.util.Arrays;

public class PartitionProblem {


    /*Driver function to check for above function*/
    public static void main(String[] args) {

        int arr[] = {3, 1, 5, 5};
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two " +
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }

    private static boolean findPartition(int[] arr, int n) {
        Integer sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

        if (sum % 2 == 0)
            return isPartition(arr, 0, sum, 0);
        else
            return false;
    }

    private static boolean isPartition(int[] arr, int i, int arraySum, int secondSetSum) {

        if (i == arr.length && arraySum != secondSetSum)
            return false;

        if (arraySum == secondSetSum)
            return true;

        boolean include = isPartition(arr, i + 1, arraySum - arr[i], secondSetSum + arr[i]);
        boolean exclude = isPartition(arr, i + 1, arraySum, secondSetSum);

        return include || exclude;
    }
}
