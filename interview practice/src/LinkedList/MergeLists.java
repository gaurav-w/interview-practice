package LinkedList;

public class MergeLists {
    Node head;

    // Driver Code
    public static void main(String args[]) {
    /* Let us create two sorted linked
       lists to test the methods
       Created lists:
           llist1: 5->10->15,
           llist2: 2->3->20
    */
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        // Node head1 = new Node(5);
        llist1.addToTheLast(new Node(5));
        llist1.addToTheLast(new Node(10));
        llist1.addToTheLast(new Node(15));

        // Node head2 = new Node(2);
        llist2.addToTheLast(new Node(2));
        llist2.addToTheLast(new Node(3));
        llist2.addToTheLast(new Node(20));


        llist1.head = sortedMerge(llist1.head,
                llist2.head);
        llist1.printList();

    }

    /*

     */
    private static Node sortedMerge(Node head1, Node head2) {

        if (head1 == null && head2 == null)
            return null;
        else if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;

        //get the new Head of the list
        Node newHead = null;
        if (head1.data > head2.data) {
            newHead = head2;
            head2 = head2.next;
        } else {
            newHead = head1;
            head1 = head1.next;
        }


        Node temp = newHead;
        //continue while either head is not null
        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                temp.next = head2;
                head2 = head2.next;

            } else {
                temp.next = head1;
                head1 = head1.next;
            }
            temp = temp.next;
        }

        //if any one head is null then list points to other head nodes
        if (head1 == null && head2 == null)
            return newHead;
        else if (head1 == null)
            temp.next = head2;
        else if (head2 == null)
            temp.next = head1;


        return newHead;
    }

    /* Method to insert a node at
   the end of the linked list */
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Method to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
