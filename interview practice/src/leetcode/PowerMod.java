package leetcode;

public class PowerMod {

    public static void main(String[] args) {
        PowerMod p = new PowerMod();
        System.out.println(p.pow(-1, 1, 20));
        System.out.println(-1 % 20);

    }


    public int pow(int x, int n, int d) {

        if (x == 0)
            return 0;

        x = x % d;

        int ans = 1;
        long exp = n;

        //if n is -ve - make it positive and
        //in the end it would be 1/(ans)
        if (n < 0)
            exp = -exp;

        while (exp > 0) {

            // if n is odd then ans = ans * x -> n-1
            if (exp % 2 == 1) {
                ans = Math.floorMod(ans * x, d);
                // exp--;
            }

            //if n is even - then  x =   x * x -> n/2
            // if(exp % 2==0) {
            x = Math.floorMod(x * x, d);
            exp = exp / 2;
            // }

        }

        if (n < 0) {
            ans = (int) 1 / ans;
        }

        ans = ans % d;
        return ans;
    }

}
