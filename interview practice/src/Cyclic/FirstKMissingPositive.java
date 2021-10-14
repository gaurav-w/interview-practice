package Cyclic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> presentInArray = new HashSet<>();

        int count = 0;
        int n = nums.length;

        while (count < n) {

            if (nums[count] > 0 && nums[count] <= n && nums[count] != nums[nums[count] - 1])
                swap(nums, count, nums[count] - 1);
            else
                count++;
        }

        //get missing nos in the array
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                presentInArray.add(nums[i]);
            }

            if (missingNumbers.size() == k)
                return missingNumbers;
        }

        //get missing nos exceeding  the array  -- this section couldnt do
        for (int i = n; k > missingNumbers.size(); i++) {
            if (!presentInArray.contains(i + 1))
                missingNumbers.add(i + 1);
        }

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = null;
//         missingNumbers = FirstKMissingPositive.findNumbers(new int[]{3, -1, 4, 5, 5}, 3);
//        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[]{2, 3, 4}, 3);
        System.out.println("Missing numbers: " + missingNumbers);

//        missingNumbers = FirstKMissingPositive.findNumbers(new int[]{-2, -3, 4}, 2);
//        System.out.println("Missing numbers: " + missingNumbers);
    }
}
