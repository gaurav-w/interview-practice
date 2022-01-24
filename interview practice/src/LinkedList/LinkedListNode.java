package LinkedList;

class LinkedListNode {
	public int key;
	public int data;
	public LinkedListNode next;
	public LinkedListNode arbitraryPointer;

	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(int key, int data) {
		this.key = key;
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
	}

	public LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitraryPointer) {
		this.data = data;
		this.next = next;
		this.arbitraryPointer = arbitraryPointer;
	}

	public static LinkedListNode createLinkedList(int[] arr) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for (int i = 0; i < arr.length; ++i) {
			LinkedListNode newNode = new LinkedListNode(arr[i]);
			if (head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
			}
			tail = newNode;
		}
		return head;
	}

	public static void display(LinkedListNode head) {
		LinkedListNode temp = head;
		while (temp != null) {
			System.out.printf("%d", temp.data);
			temp = temp.next;
			if (temp != null) {
				System.out.printf(", ");
			}
		}
		System.out.println();
	}
}