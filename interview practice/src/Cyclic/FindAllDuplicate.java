package Cyclic;

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int n = nums.length;
        int count = 0;
        while (count < n) {
            if (nums[count] != count + 1) {
                if (nums[count] != nums[nums[count] - 1])
                    swap(nums, count, nums[count] - 1);
                else
                    duplicateNumbers.add(nums[count]);
            } else
                count++;

        }

        return duplicateNumbers;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[]{3, 4, 4, 5, 5});
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[]{5, 4, 7, 2, 3, 5, 3});
        System.out.println("Duplicates are: " + duplicates);
    }
}

