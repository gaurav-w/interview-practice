package babbar.recursion.LinkedList;

/**
 * 
 * @author gaura
 *
 */

public class reverseLL{

	public static void main(String[] args) {
		LL a = new LL(1);
		LL b = new LL(2);
		LL c = new LL(3);
		LL d = new LL(4);

		a.next = b;
		b.next = c;
		c.next = d;
		traverse(a);

		System.out.println();
		LL newhead = reverseLL(a);
		traverse(newhead);

		System.out.println();
		LL newhead2 = nonrecursiveReverse(newhead);
		traverse(newhead2);
		// KthNodeFromEndLLRecursion2(a, 3);

	}

	static void traverse(LL head) {

		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
	}

	/**
	 * Solve for 1 and let recursion do rest Have faith it will go correct
	 * 
	 * @param head
	 * @return
	 */
	static LL reverseLL(LL head) {

		if (head == null || head.next == null)
			return head;

		LL newHead = reverseLL(head.next);

		head.next.next = head;
		head.next = null;

		return newHead;
	}

	/**
	 * Have curr and prev pointers
	 * 
	 * @param head
	 * @return
	 */
	static LL nonrecursiveReverse(LL head) {

		LL curr = head;
		LL prev = null;
		LL next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

}
