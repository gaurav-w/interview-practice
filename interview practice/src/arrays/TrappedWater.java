package arrays;

public class TrappedWater {


    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1,
                3, 2, 1, 2, 1};
        int n = arr.length;

        System.out.println("Maximum water that can be accumulated is "
                + findWater(arr, n));
    }

    private static int findWater(int[] arr, int n) {

        int totalWater = 0;
        int currentWater = 0;

        for (int i = 0; i < n - 2; i++) {
            totalWater = totalWater + getCurrentWater(arr[i], arr[i + 1], arr[i + 2]);
        }
        return totalWater;
    }

    private static int getCurrentWater(int first, int second, int third) {
        if (second < first && second < third) {
            int waterLevel = Math.min(first, third);
            return waterLevel - second;
        } else
            return 0;
    }
}
