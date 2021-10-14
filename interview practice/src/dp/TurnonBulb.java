package dp;

public class TurnonBulb {

    int allDone = 0;

    public static void main(String[] args) {

        // System.out.println( new TurnonBulb().solve(10));
        System.out.println(new TurnonBulb().calc(13736));

    }


    public int calc(int A) {

        int addedValue = 0;
        int modValue = A % 6;

        if (modValue == 0)
            return (A / 6) * 2;
        else {

            if (modValue == 1)
                addedValue = 1;

            if (modValue > 2)
                addedValue = 2;
        }
        return ((A / 6) * 2) + addedValue;

    }

    public int solve(int A) {
        int res[] = new int[A];

        if (A == 1)
            return 1;
        if (A == 2)
            return 2;


        return recurse(res, A, A / 2);
    }

    public int recurse(int res[], int A, int curr) {

        //base
        if (curr < 0 || curr >= A)
            return 0;

        int ans = 0;
        //operations
        if (res[curr] == 0) {
            res[curr] = 1;
            ans = 1;
        }

        if (curr - 2 >= 0 && res[curr - 2] == 0) {
            res[curr - 2] = 1;
            ans = 1;
        }

        if (curr + 2 < A && res[curr + 2] == 0) {
            res[curr + 2] = 1;
            ans = 1;
        }

        int all = 1;
        for (int i = 0; i < A; i++) {
            if (res[i] == 0) {
                all = 0;
                break;
            }
        }

        int min = A;

        if (all == 1) {
            allDone = all;
            return ans;

        } else {
            for (int i = 0; i < A - curr && allDone == 0; i++) {
                min = Math.min(min, ans + recurse(res, A, curr + 1));
            }

        }

        return min;
    }


}
