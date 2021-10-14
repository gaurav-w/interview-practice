package arrays;

/*
You are given an array of n+2 elements. All elements of the array are in range 1 to n.
And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 */
class RepeatElement {
    public static void main(String[] args) {
        RepeatElement repeat = new RepeatElement();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        repeat.printRepeating(arr, arr_size);
    }

    void printRepeating(int arr[], int size) {
        /* S is for sum of elements in arr[] */
        int S = 0;

        /* P is for product of elements in arr[] */
        int P = 1;

        /* x and y are two repeating elements */
        int x, y;

        /* D is for difference of x and y, i.e., x-y*/
        int DiffXY;

        int n = size - 2, i;

        /* Calculate Sum and Product of all elements in arr[] */
        for (i = 0; i < size; i++) {
            S = S + arr[i];
            P = P * arr[i];
        }

        /* S is x + y now */
        int SumXY = S - n * (n + 1) / 2;

        /* P is x*y now */
        int PofXY = P / factorial(n);

        /* D is x - y now */
        DiffXY = (int) Math.sqrt(SumXY * SumXY - 4 * PofXY);


        x = (DiffXY + SumXY) / 2;
        y = (SumXY - DiffXY) / 2;

        System.out.println("The two repeating elements are :");
        System.out.print(x + " " + y);
    }

    int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return factorial(n - 1) * n;
    }
//    int fact(int n) {
//        return (n == 0) ? 1 : n * fact(n - 1);
//    }
}


