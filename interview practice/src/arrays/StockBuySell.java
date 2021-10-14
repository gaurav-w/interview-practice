package arrays;

import java.util.ArrayList;

public class StockBuySell {

    public static void main(String args[]) {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // function call
        stock.stockBuySell(price, n);
    }

    /*
    The idea to maimize profit by finding local minikum and local maximum
    local minima is if the elements after it are only increasing
    local maxima is if the elements after it are onlky decreasing

    We loop the list.
    Try to find local minima. If found store in Interval.
    Try to find the local maxima after it. It found store in Interval and add to list.

     */
    private void stockBuySell(int[] price, int n) {

        int i = 0;
        Interval interval;
        ArrayList<Interval> al = new ArrayList<>();

        while (i < n - 1) {
            //local minima - 1 day less than actual elemtns
            while ((i < n - 1) && price[i] >= price[i + 1])
                i++;

            if (i < n - 1) {
                interval = new Interval();
                interval.buy = i;
                i++;
            } else
                break;

            //local maxima - goes till last element
            while ((i < n) && price[i] >= price[i - 1])
                i++;

            interval.sell = i - 1;
            al.add(interval);

        }

        if (al.size() == 0) {
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        } else {
            int profit = 0;
            for (Interval inter : al) {
                System.out.println("Buy on day: " + inter.buy
                        + "        "
                        + "Sell on day : " + inter.sell);
            }
        }
    }
}

class Interval {
    int buy;
    int sell;
}