package dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinJump {


    public static void main(String[] args) {
        int a[] = {33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0,
                31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0,
                47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19,
                2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0,
                1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2,
                33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16,
                10, 23, 22, 41, 32, 14, 22, 16, 23, 38,
                42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28};


        ArrayList<Integer> A = (ArrayList) Arrays.stream(a).boxed().collect(Collectors.toList());
        ;

        System.out.println(jump(A));
    }

    public static int jump(ArrayList<Integer> A) {

        int res[] = new int[A.size()];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        for (int i = 0; i < A.size(); i++) {
            if (i > 0 && res[i] != Integer.MAX_VALUE) {
                for (int j = i + 1; j <= i + A.get(i); j++) {
                    if (j < res.length) {
                        res[j] = Math.min(res[j], res[i] + 1);
                    }
                }
            }
        }

        return res[A.size() - 1] == Integer.MAX_VALUE ? -1 : res[A.size() - 1];
    }
}
