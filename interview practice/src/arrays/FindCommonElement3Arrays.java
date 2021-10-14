package arrays;

import java.util.ArrayList;

public class FindCommonElement3Arrays {


    // Driver code to test above
    public static void main(String args[]) {
        FindCommonElement3Arrays ob = new FindCommonElement3Arrays();

        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        ob.findCommon(ar1, ar2, ar3);
    }

    private void findCommon(int[] ar1, int[] ar2, int[] ar3) {
        ArrayList<Integer> commonElements = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while (i < ar1.length && j < ar2.length && k < ar3.length) {

            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                commonElements.add(ar1[i]);
                i++;
                k++;
                j++;
            } else if (ar1[i] > ar2[j]) {
                j++;
            } else if (ar2[j] > ar3[k]) {
                k++;
            } else
                i++;

        }

        System.out.print("Common Elements are : ");
        for (Integer common : commonElements) {
            System.out.print(common + " ");
        }
    }


}
