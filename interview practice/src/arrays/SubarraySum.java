package arrays;

import java.util.HashMap;

/*
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum arraysum = new SubarraySum();
        int arr[] = {13, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 19;
        arraysum.subArraySum(arr, n, sum);
    }


    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cumulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }


//    private void subArraySum(int[] arr, int n, int sum) {
//        int i=0, j=1;
//        int currentSum = 0;
//        while (i < j && i < n && j < n) {
//            currentSum = currentSum + arr[i];
//            if (currentSum == sum) {
//                System.out.println("Sum found between indexes " + i + " and " + j);
//            } else if ( currentSum > sum ) {
//                i++;
//                currentSum = currentSum - arr[i];
//            } else {
//                j++;
//                currentSum = currentSum + arr[j];
//            }
//        }
//
//    }


}
