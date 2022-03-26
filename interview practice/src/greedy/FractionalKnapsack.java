package greedy;

import java.text.DecimalFormat;
import java.util.Arrays;



class FractionalKnapsack {
	public static class Item {
		int index;
		double valueWtRatio;
	}
	/*
	 * 1. make array of val/wt 2. sort the array 3. while (wtofKnacsack is less than
	 * capcity) 4. keep adding the item which has the max value in array 5. check if
	 * full item can be added else add its fraction and value. 6. return value
	 */
	public static double getMaxValue(double[] w, double[] v, double c) {

		double KnapsackWt = 0;
		double KnapsackValue = 0;
		Item items[] = new Item[w.length];

		for (int i = 0; i < items.length; i++) {
			items[i] = new Item();
			items[i].valueWtRatio = v[i] / w[i];
			items[i].index = i;
		}

		Arrays.sort(items, (a, b) -> ((a.valueWtRatio - b.valueWtRatio) > 0.0 ? 1 : 0));
		int index = 0;

		while (KnapsackWt < c && index < items.length) {
			if (w[items[index].index] < c - KnapsackWt) {
				KnapsackWt = KnapsackWt + w[items[index].index];
				KnapsackValue = KnapsackValue + v[items[index].index];
				index++;
				System.out.println(
						"c, v, t = " + (c - KnapsackWt) + ", " + v[items[index].index] + ", " + KnapsackValue + "\n");
			} else {
				double wtTaken = c - KnapsackWt;
				double valueTaken = items[index].valueWtRatio * wtTaken;
				KnapsackWt = KnapsackWt + wtTaken;
				KnapsackValue = KnapsackValue + valueTaken;
				System.out.println("c, v, t = " + (c - KnapsackWt) + ", " + valueTaken + ", " + KnapsackValue + "\n");
			}
		}

		return KnapsackValue;
	}

	public static void main(String[] args) {
		DecimalFormat decimal = new DecimalFormat("#.##"); // this class rounds off the double upto 2 decimal places

		double[] weights = { 2, 1, 6, 0.5, 0.25, 7 };
		double[] values = { 50, 70, 100, 50, 30, 99 };
		int capacity = 10;

		double maxValue = getMaxValue(weights, values, capacity);
		System.out.println("Maximum value we can obtain = " + decimal.format(maxValue));
	}
}