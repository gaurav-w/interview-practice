package arrays;

//find the element occurring odd number of times
//Given an array of positive integers. All numbers occur even number of times except one
// number which occurs odd number of times. Find the number in O(n) time & constant space.
public class NumberOddTimes {

    public static void main(String[] args) {
        NumberOddTimes occur = new NumberOddTimes();
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        int n = ar.length;
        System.out.println(occur.getOddOccurrence(ar, n));
    }

    private int getOddOccurrence(int[] ar, int n) {
        int xor = ar[0];

        for (int i = 1; i < ar.length; i++) {
            xor = ar[i] ^ xor;
        }
        return xor;
    }

}
