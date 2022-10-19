package babbar.recursion.arrays;

/**
 * Increasing Decreasing
 * 
 * @author gaura
 *
 */
public class IncreasingDecreasing {

	/*
	 * Head Recursion - Increasing
	 */
	public static void fInc(int n) {
		if (n == 0)
			return;

		fInc(n - 1);

		System.out.print(n + " ");
	}

	/*
	 * Tail Recursion - Decreasing
	 */
	public static void fDec(int n) {
		if (n == 0)
			return;

		System.out.print(n + " ");

		fDec(n - 1);

	}

	public static void f(int n) {
		fInc(n);
		fDec(n);
	}

	public static void main(String[] args) {
		f(5);
	}

}
