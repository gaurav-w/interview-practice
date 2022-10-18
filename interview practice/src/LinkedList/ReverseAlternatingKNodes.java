package LinkedList;

public class ReverseAlternatingKNodes {

	public static ListNode reverse(ListNode head, int k, boolean reverse) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int count = 0;

		if (head == null)
			return null;

		if (reverse) {
			while (curr != null && count < k) {

				next = curr.next;
				if (reverse == true)
					curr.next = prev;
				prev = curr;
				curr = next;

				count++;
			}
		}

		if (reverse) {
			head.next = reverse(curr, k, !reverse);
			return prev;
		} else {
			if (prev != null)
				prev.next = reverse(curr, k, !reverse);
			return head;
		}

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseAlternatingKNodes.reverse(head, 2, true);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
