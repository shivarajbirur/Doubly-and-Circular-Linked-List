package Problem;

/**
 * Implementation of LinkedList with insert, delete, and display operations.
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

    // Insert at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            insertAtStart(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at a specific index
    public void insertAtSpecificIndex(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < index - 1) {
            temp = temp.next;
            currentIndex++;
        }

        if (temp == null) {
            System.out.println("Index out of Bound");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete the first node
    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        head = head.next;
    }

    // Delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at a specific index
    public void deleteAtSpecificPosition(int index) {
        if (index < 0) {
            System.out.println("Invalid Index ");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (index == 0) {
            deleteAtFirst();
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        while (temp.next != null && currentIndex < index - 1) {
            temp = temp.next;
            currentIndex++;
        }

        if (temp.next == null) {
            System.out.println("Index out of Bound");
            return;
        }

        temp.next = temp.next.next;
    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currentNode = head;
        System.out.print("head --> ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    // Get head node (for solution class)
    public Node getHead() {
        return head;
    }

    // Set head node (for updating after removing duplicates)
    public void setHead(Node newHead) {
        this.head = newHead;
    }
}

/**
 * Solution class to remove duplicates from a sorted linked list.
 */
class Solution {

    public LinkedList.Node deleteDuplicates(LinkedList.Node head) {
        if (head == null) {
            return null;
        }

        LinkedList.Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;  // Skip duplicate node
            } else {
                current = current.next;  // Move to the next node
            }
        }

        return head;
    }
}

/**
 * Main class to test the solution.
 */
public class Leetcode83 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements into the sorted linked list
        list.insertAtEnd(1);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(3);

        System.out.print("Original List: ");
        list.printList();

        // Remove duplicates using OOP approach
        Solution solution = new Solution();
        list.setHead(solution.deleteDuplicates(list.getHead()));

        System.out.print("List after removing duplicates: ");
        list.printList();
    }
}
