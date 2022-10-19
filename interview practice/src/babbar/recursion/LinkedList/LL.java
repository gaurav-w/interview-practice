package babbar.recursion.LinkedList;

public class LL {
	public int data;
	public LL next;

	public LL(int d) {
		this.data = d;
	}

	static void traverse(LL head) {

		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println("");
	}
}