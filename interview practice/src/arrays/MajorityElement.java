package arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        int n = arr.length;

        // Function calling
        findMajority(arr, n);
        findMajority2(arr, n);
        findMajority3(arr, n);
    }

    /*
    Finds element by making a Hashmap and counting them.
    Retrieves the count to see if it is greater than  n/2.
     */
    private static void findMajority(int[] arr, int n) {
        int majorityElement = arr[0];
        int currentElement = arr[0];

        // Arrays.sort(arr);
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (counter.containsKey(arr[i])) {
                counter.put(arr[i], counter.get(arr[i]) + 1);
            } else {
                counter.put(arr[i], 1);
            }
        }

        boolean hasMajority = false;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > (n / 2)) {
                hasMajority = true;
                System.out.println("Majority element " + entry.getKey());
            }
        }

        if (hasMajority == false) {
            System.out.println("No Majority element ");
        }
    }

    /*
     Use two loops to keep a count of each.
     */
    private static void findMajority2(int[] arr, int n) {

        int count = 0;
        int maxCount = 0;
        int majorityElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    majorityElement = arr[i];
                }
            }
        }

        if (maxCount > (n / 2))
            System.out.println("Majority element " + majorityElement);
        else
            System.out.println("no Majority element");
    }

    /*
    Moores Voting algorithm
    1. If previous and next element is same - increase counter - store majorityelement
    2. if not decrease counter.

    if counter is +ve loop again on the array to test if that is mejoriy element.
     */
    private static void findMajority3(int arr[], int n) {

        int count = 1;
        int majorityElement = arr[0];

        int maxCount = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else
                count--;

            if (count == 0) {
                count = 1;
                majorityElement = arr[i];
            }

        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == majorityElement)
                count++;
        }

        if (count > (n / 2))
            System.out.println("Majority element " + majorityElement);
        else
            System.out.println("no Majority element");

    }

}
