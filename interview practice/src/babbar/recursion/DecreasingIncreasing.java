package babbar.recursion;

/**
 * Print decreasing numbers and then increasing numbers using recursion
 * 
 * @author gaura
 *
 */
public class DecreasingIncreasing {

	public static void f(int n) {
		if (n == 0)
			return;

		System.out.print(n + " ");

		f(n - 1);

		System.out.print(n + " ");
	}

	public static void main(String[] args) {
		f(5);

	}

}
