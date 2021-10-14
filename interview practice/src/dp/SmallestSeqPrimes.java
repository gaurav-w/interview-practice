package dp;

import java.util.ArrayList;

public class SmallestSeqPrimes {

    public static void main(String[] args) {

        System.out.println(solve(2, 2, 2, 1));
    }

    public static ArrayList<Integer> solve(int A, int B, int C, int D) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int aMultiples[] = new int[D];
        int bMultiples[] = new int[D];
        int cMultiples[] = new int[D];

        for (int i = 0; i < D; i++) {
            aMultiples[i] = A * (i + 1);
            bMultiples[i] = B * (i + 1);
            cMultiples[i] = C * (i + 1);
        }


        int i = 0, j = 0, k = 0;
        while ((i + j + k) < D) {
            if (aMultiples[i] < bMultiples[j] &&
                    aMultiples[i] < cMultiples[k]) {
                result.add(aMultiples[i]);
                i++;
            } else if (bMultiples[j] < aMultiples[i] &&
                    bMultiples[j] < cMultiples[k]) {
                result.add(bMultiples[j]);
                j++;
            } else if (cMultiples[k] < aMultiples[i] &&
                    cMultiples[k] < bMultiples[j]) {
                result.add(cMultiples[k]);
                k++;
            }
        }

        return result;

    }

}
