package arrays;

import static arrays.RotateArray.printArray;

public class ReplaceNextGreatest {

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        nextGreatest(arr);
        System.out.println("The modified array:");
        printArray(arr);
    }

    /*
    Replace the greatest on right hand side.
    The rightmost will -1. - size -1
    Start the changes with size-2
     keep comparing with the right and update it after replacing it
     */
    private static void nextGreatest(int[] arr) {

        int rightMostGreatest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = rightMostGreatest;

            if (rightMostGreatest < temp)
                rightMostGreatest = temp;
        }
    }
}
