package maps;

import java.util.HashSet;

public class UnionIntersectionChallenge {

	public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		SinglyLinkedList<T>.Node union = list1.getHeadNode();
		result.setHeadNode(union);
		HashSet<T> set = new HashSet<>();

		SinglyLinkedList<T>.Node prev = null;

		if (list1.getHeadNode() != null) {

			while (union != null) {
				if (set.contains(union.data)) {
					prev = prev.nextNode.nextNode;
				} else {
					set.add(union.data);
					prev = union;
				}
				union = union.nextNode;
			}
		}

		if (list2.getHeadNode() != null) {

			prev.nextNode = list2.getHeadNode();
			union = list2.getHeadNode();

			while (union != null) {
				if (set.contains(union.data)) {
					prev = prev.nextNode.nextNode;
				} else {
					set.add(union.data);
					prev = union;
				}
				union = union.nextNode;
			}
		}

		return result;
	}

	// performs intersection between list
	public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1,
			SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();

		SinglyLinkedList<T>.Node intersection = new SinglyLinkedList.Node();
		result.setHeadNode(intersection);

		SinglyLinkedList<T>.Node current = list1.getHeadNode();
		HashSet<T> set = new HashSet<>();

		while (list1 != null) {
			if (set.contains(current.data)) {
				intersection.data = current.data;
				intersection.nextNode = new SinglyLinkedList.Node();
				intersection = intersection.nextNode;
			} else {
				set.add(current.data);
			}
			current = current.nextNode;
		}

		current = list2.getHeadNode();
		while (list2 != null) {
			if (set.contains(current.data)) {
				intersection.data = current.data;
				intersection.nextNode = new SinglyLinkedList.Node();
				intersection = intersection.nextNode;
			} else {
				set.add(current.data);
			}
			current = current.nextNode;
		}

		return result;
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		for (int i = 7; i > 3; i--) {
			list1.insertAtHead(i);
		}
		System.out.print("1st ");
		list1.printList();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			list2.insertAtHead(i);
		}
		System.out.print("2nd ");
		list2.printList();
		System.out.print("After Intersection ");
		intersectionWithHashing(list1, list2).printList();
		System.out.print("After Union ");
		unionWithHashing(list1, list2).printList();
	}
}