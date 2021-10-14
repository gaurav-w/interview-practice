package Cyclic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int n = nums.length;
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            System.out.print("nums[i]->" + nums[i]);
            System.out.println(" nums[nums[i] - 1]->" + nums[nums[i] - 1]);
            if (nums[i] != nums[nums[i] - 1]) {
                System.out.println(" i , nums[i] - 1 ->" + i + " , " + (nums[i] - 1));
                swap(nums, i, nums[i] - 1);
                Arrays.stream(nums).forEach(System.out::print);
                System.out.println("");
            } else
                i++;
        }

//        while(count<n){
//            if( nums[count] != count+1 && nums[count]<n) {
//                System.out.print( "first->" + nums[count]);
//                System.out.println( " second->" + count);
//                swap(nums, nums[count], count);
//                Arrays.stream(nums).forEach(System.out::print);
//                System.out.println("");
//            }
//            else
//                count++;
//        }

        count = 0;
        while (count < n) {
            if (nums[count] != count + 1)
                missingNumbers.add(count + 1);
            count++;
        }
        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[]{2, 4, 1, 2});
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[]{2, 3, 2, 1});
        System.out.println("Missing numbers: " + missing);
    }
}
