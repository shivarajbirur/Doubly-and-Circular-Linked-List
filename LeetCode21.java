package Problem;
/**
 * LinkedList class with basic operations.
 */
class LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    // Get head node (for merging)
    public Node getHead() {
        return head;
    }

    // Set head node (after merging)
    public void setHead(Node newHead) {
        this.head = newHead;
    }
}

/**
 * Solution class to merge two sorted linked lists.
 */
class Solution {
    public LinkedList.Node mergeTwoLists(LinkedList.Node list1, LinkedList.Node list2) {
        LinkedList linkedList = new LinkedList();  // For returning merged list
        LinkedList.Node dummy = linkedList.new Node(-1);  // Dummy node
        LinkedList.Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach remaining elements from either list
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return dummy.next;
    }
}

/**
 * Main class to test the solution.
 */
public class LeetCode21 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(4);

        LinkedList list2 = new LinkedList();
        list2.insertAtEnd(1);
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);

        System.out.print("List 1: ");
        list1.printList();
        System.out.print("List 2: ");
        list2.printList();

        Solution solution = new Solution();
        LinkedList mergedList = new LinkedList();
        mergedList.setHead(solution.mergeTwoLists(list1.getHead(), list2.getHead()));

        System.out.print("Merged List: ");
        mergedList.printList();
    }
}
