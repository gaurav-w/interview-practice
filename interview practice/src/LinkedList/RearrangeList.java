package LinkedList;


class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {


    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode Next = head.next;
            head.next = prev;
            prev = head;
            head = Next;
        }

        return prev;
    }

    private static void insertAlternative(ListNode head1, ListNode head2) {
        int c = 1;
        ListNode head = head1;
        head1 = head1.next;

        while (head1 != null && head2 != null) {
            if (c % 2 == 0) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            c++;
            head = head.next;
        }
    }

    public static void reorder(ListNode head) {
        ListNode mid = getMid(head);
        ListNode reversedHalf = reverseList(mid);
        insertAlternative(head, reversedHalf);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}