package arrays;

public class SmallestMissingNumber {

    public static void main(String[] args) {
        SmallestMissingNumber small = new SmallestMissingNumber();
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        System.out.println("First Missing element is : "
                + small.findFirstMissing2(arr, n));
    }

    //o(n)
    private int findFirstMissing(int[] arr, int size) {
        for (int j = 0; j < size; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return size;
    }

    //O(logn)
    private int findFirstMissing2(int[] arr, int size) {
        return findMissingBinary(arr, 0, size - 1);
    }

    private int findMissingBinary(int arr[], int start, int end) {
        if (arr[start] != start)
            return start;

        if (start > end) {
            return end + 1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == mid)
            return findMissingBinary(arr, mid + 1, end);
        else
            return findMissingBinary(arr, start, mid);
    }
}
