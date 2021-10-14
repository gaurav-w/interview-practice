public class DutchFlag {

    public static void sort(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    public static void sort2(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right && left < arr.length && right < arr.length) {

            while (arr[left] == 0 && left < arr.length)
                left++;

            right = 0;
            while (arr[right] != 0 && right < arr.length)
                right++;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left = Math.min(left, right) + 1;
            right = Math.max(left, right) + 1;
        }

        while (left < right && left < arr.length && right < arr.length) {

            while (arr[left] == 1 && left < arr.length)
                left++;

            while (arr[right] != 2 && right < arr.length)
                right++;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left = Math.min(left, right) + 1;
            right = Math.max(left, right);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort2(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort2(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
