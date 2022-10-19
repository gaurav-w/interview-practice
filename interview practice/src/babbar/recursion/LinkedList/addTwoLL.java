package babbar.recursion.LinkedList;

/**
 * 
 * @author gaura
 *
 */

/**
 * Idea is use reverse of LL
 * Reverse both and add them.
 * Reverse the result again
 * @author gaura
 *
 */
public class addTwoLL {

	public static void main(String[] args) {
		LL a = new LL(1);
		LL b = new LL(2);
		LL c = new LL(3);
		a.next = b;
		b.next = c;

		LL f = new LL(2);
		LL g = new LL(2);
		f.next = g;

		System.out.println("LL1");
		LL.traverse(a);
		System.out.println("LL2");
		LL.traverse(f);

		LL result = addLL(a, f);
		LL.traverse(result);

	}

	private static LL addLL(LL a, LL f) {
		LL areverse = reverse(a);
		LL freverse = reverse(f);

		LL resultReverse = addLLHelper(areverse, freverse, 0);
		LL result = reverse(resultReverse);
		return result;
	}

	private static LL addLLHelper(LL areverse, LL freverse, int carry) {
		int data = 0;

		if (areverse == null && freverse == null)
			return null;

		if (areverse != null && freverse != null) {
			data = areverse.data + freverse.data + carry;
		} else if (areverse == null) {
			data = freverse.data + carry;
		} else if (freverse == null) {
			data = areverse.data + carry;
		}
		if (data > 10)
			carry = 1;
		data = data % 10;
		LL newNode = new LL(data);
		newNode.next = addLLHelper(areverse == null ? null : areverse.next, freverse == null ? null : freverse.next,
				carry);
		return newNode;
	}

	private static LL reverse(LL head) {
		if (head == null || head.next == null) {
			return head;
		}
		LL newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}
