package dp;

public class MinNoOfCoins {

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int v = 11;
        System.out.println(minNofCoins(coins, v, coins.length - 1));
    }


    static int minNofCoins(int coins[], int v, int i) {
        if (v <= 0 || i < 0)
            return 0;

        if (v > coins[i])
            return Math.min(1 + minNofCoins(coins, v - coins[i], i),
                    minNofCoins(coins, v, i - 1));

        else
            return minNofCoins(coins, v, i - 1);
    }


}
