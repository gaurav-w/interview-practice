package babbar.recursion;

/**
 * 
 * @author gaura
 *
 */
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

		// KthNodeFromEndLLRecursion(a, 3);
		KthNodeFromEndLLRecursion2(a, 4);
		KthNodeFromEndLLRecursion2(a, 3);

	}

	/*
	 * Head Recursion - > WONT WORK in JAVA unless we take k to be Reference var
	 * Works in c++
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

	/**
	 * Java way
	 * 
	 * @param head
	 * @param k
	 */
	static void KthNodeFromEndLLRecursion2(LL head, int k) {

		if (head == null || k < 0) // head null or k invalid
			return;
		LL temp = head;

		int lengthOfLL = 0;
		while (temp != null) {
			temp = temp.next;
			lengthOfLL++;
		}

		if (lengthOfLL < k) // not possible as list is lesser than k
			return;

		int count = lengthOfLL - k;
		temp = head;
		while (count > 0) {
			temp = temp.next;
			count--;
		}

		System.out.println(temp.data);

	}

}
