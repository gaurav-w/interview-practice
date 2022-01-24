package LinkedList;

public class ReverseK {
	/*
	 * 1. start and end of n list 2. reverse them. 3. start.next = temp; 4.
	 * previousBlockEnd.next = end; 5. previousBlockEnd = start;
	 */
	static LinkedListNode reverseKNodes(LinkedListNode head, int k) {

		LinkedListNode node = head;
		LinkedListNode startOfBlock = null, endOfBlock = null, previousBlockEnd = null, nextNode=null, previous =null;
		int first = 1;

		if (k <= 0)
			return head;

		while (node != null) {
			int currentK = 1;
			startOfBlock = null;
			endOfBlock = null;

			while (currentK < k && node != null) {
				if (currentK == 1) {
					startOfBlock = node;
				}
				previous = node;
				node = node.next;
				
				currentK++;
			}
			
			if(node!=null) {
				endOfBlock = node;
				nextNode = node.next;
			} else {
				endOfBlock = previous;
				nextNode = previous.next;
			}
			
			// reverse
			reverseList(startOfBlock, endOfBlock);

			startOfBlock.next = node; // k+1 th node

			if (previousBlockEnd != null)
				previousBlockEnd.next = endOfBlock;

			previousBlockEnd = startOfBlock;
			

			if (first == 1) {
				head = endOfBlock;
				first = 0;
			}
			
			node = nextNode;
		}

		return head;
	}

	public static void reverseList(LinkedListNode from, LinkedListNode to) {
		LinkedListNode previous = null, current = null, temp = null, next = null;
		LinkedListNode stop = to.next;
		current = from;
		previous = null;

		while (current != stop) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
	}

	public static void main(String[] args) {
		int[] v1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		LinkedListNode listHead = LinkedListNode.createLinkedList(v1);
		System.out.print("Original list: ");
		LinkedListNode.display(listHead);

		listHead = reverseKNodes(listHead, 4);
		System.out.print("List reversed by 4: ");
		LinkedListNode.display(listHead);
	}
}