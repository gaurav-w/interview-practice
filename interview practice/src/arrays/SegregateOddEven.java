package arrays;

public class SegregateOddEven {

    public static void main(String[] args) {
        // Given array arr[]
        int[] arr = {18, 52, 37, 70,
                3, 63, 2, 34};

        // Function Call
        segregate(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void segregate(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {

            while (arr[left] % 2 == 0)
                left++;

            if (left >= right)
                continue;

            while (arr[right] % 2 == 1)
                right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }


}
