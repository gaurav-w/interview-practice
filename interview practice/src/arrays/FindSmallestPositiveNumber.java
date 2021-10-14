package arrays;

public class FindSmallestPositiveNumber {

    public static void main(String[] args) {
        int arr[] = {0, 1, 10, 2, -10, -20};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is " + missing);
    }

    /*
    1. Loop and Find if 1 is missing and then Mark all non positive numbers as 1
    2. Loop once more and mark all positions with -1 if they lie in the range of array size
    3. Loop once more and report the positions which are +ve
     */
    private static int findMissing(int[] arr, int arr_size) {
        //loop1
        boolean isOneMissing = true;
        for (int i = 0; i < arr_size; i++) {
            if (arr[i] == 1)
                isOneMissing = false;

            if (arr[i] <= 0) {
                arr[i] = 1;
            }
        }

        if (isOneMissing)
            return 1;


        //loop2
        for (int i = 0; i < arr_size; i++) {
            int num = Math.abs(arr[i]);
            if (arr[i] > 0 && num < arr_size - 1) {
                arr[num] = -1 * Math.abs(arr[num]);
            }

        }

        //loop3
        for (int i = 0; i < arr_size; i++) {
            if (arr[i] > 0)
                return i;
        }

        return arr_size;
    }

}
