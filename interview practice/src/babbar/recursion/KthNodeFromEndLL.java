package babbar.recursion;

class LL {
	int data;
	LL next;

	LL(int d) {
		this.data = d;
	}
}

public class KthNodeFromEndLL {

	public static void main(String[] args) {
		LL a = new LL(1);
		LL b = new LL(2);
		LL c = new LL(3);
		LL d = new LL(4);

		a.next = b;
		b.next = c;
		c.next = d;

		KthNodeFromEndLLRecursion(a, 3);

	}

	/*
	 * Head Recusion - > WONT WORK in JAVA unless we take k to be Reference var
	 * 
	 * Only way is to count and in next pass decrement
	 */
	static void KthNodeFromEndLLRecursion(LL head, int k) {

		if (head == null)
			return;

		KthNodeFromEndLLRecursion(head.next, k);

		k--;

		if (k == 0)
			System.out.println(head.data);

	}

}
