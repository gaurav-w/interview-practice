package arrays;

import java.util.Arrays;

public class FindMissingNumber {


    public static void main(String[] args) {
        FindMissingNumber small = new FindMissingNumber();
        int[] arr = {1, 3, 6, 4, 1, 2};
        int n = arr.length;
        System.out.println("First Missing element is : "
                + small.solution(arr));
    }

    public int solution(int[] A) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++)
            max = Math.max(max, A[i]);

        if (max < 0)
            return 1;


        for (int i = 0; i < A.length; i++) {

            if (Math.abs(A[i]) < A.length && A[Math.abs(A[i]) - 1] > 0)
                A[Math.abs(A[i]) - 1] = A[Math.abs(A[i]) - 1] * -1;

        }

        //    System.out.println("this is a debug message");
        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {

            if (A[i] > 0)
                return i;
        }

        return A.length;
    }

}
