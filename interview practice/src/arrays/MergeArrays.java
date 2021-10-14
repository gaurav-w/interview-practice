package arrays;

/*
There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n
and contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
 */
public class MergeArrays {

    public static void main(String[] args) {
        MergeArrays mergearrayobj = new MergeArrays();

        /* Initialize arrays */
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;

        /*Move the m elements at the end of mPlusN*/
        mergearrayobj.moveToEnd(mPlusN, m + n);

        /*Merge N[] into mPlusN[] */
        mergearrayobj.merge(mPlusN, N, m, n);

        /* Print the resultant mPlusN */
        mergearrayobj.printArray(mPlusN, m + n);
    }

    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println("");
    }

    /* Merges array N[] of size n into array mPlusN[]
      of size m+n*/
    void merge(int mPlusN[], int N[], int m, int n) {

        /* Current index of i/p part of mPlusN[]*/
        int i = n;

        /* Current index of N[]*/
        int j = 0;

        /* Current index of output mPlusN[]*/
        int k = 0;


        while (k < (m + n)) {
            /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we have
                not reached end of it
            b) We have reached end of N[] */
            if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n)) {
                mPlusN[k] = mPlusN[i];
                k++;
                i++;
            } else // Otherwise take element from N[]
            {
                mPlusN[k] = N[j];
                k++;
                j++;
            }
        }
    }

    /*
    Start with last -1 i.e j
    if current pointer is not -1 then only
    we shift current pointers contents to j
     */
    private void moveToEnd(int[] mPlusN, int size) {
        int i, j = size - 1;
        for (i = size - 1; i >= 0; i--) {

            if (mPlusN[i] != -1) {
                mPlusN[j] = mPlusN[i];
                j--;
            }
            // MergeArrays.printArray(mPlusN, size);
        }
    }
}
