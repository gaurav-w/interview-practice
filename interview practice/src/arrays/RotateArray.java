package arrays;

public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 2;

        // in case the rotating factor is
        // greater than array length
        d = d % n;
        leftRotate(arr, d); // Rotate array by d
        printArray(arr);
    }

    private static void leftRotate(int[] arr, int d) {
        RotateArray.reverse(arr, 0, d - 1);
        RotateArray.reverse(arr, d, arr.length - 1);
        RotateArray.reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}