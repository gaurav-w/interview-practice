package LinkedList;

public class MiddleElement {
    Node head;

    public static void main(String[] args) {
        MiddleElement llist = new MiddleElement();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            llist.printList();
            llist.printMiddle();
        }
    }

    void printMiddle() {
        Node slow = head;
        Node fast = head;

//        while (fast != null) {
//
//            fast = fast.next;
//
//            if (fast == null) {
//                System.out.println("The middle element is [" +
//                        slow.data + "]");
//            } else {
//                fast = fast.next;
//                slow = slow.next;
//            }
//        }

        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.data + "] \n");
        }
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
}
