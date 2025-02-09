
class DoublyLinkedList {

    class Node {

        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    //Insert At Start
    public void InsertAtStart(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert At End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            InsertAtStart(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert At Specific Index
    public void insertAtSpecificIndex(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);

        if (index == 0) {
            InsertAtStart(data);
            return;
        }
        Node temp = head;
        int currentNode = 0;

        while (temp != null && currentNode < index - 1) {
            temp = temp.next;
            currentNode++;
        }
        if (temp == null) {
            System.out.println("Index out of Bound");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }

    }

    // Delete the last node
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete the last node
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        if (temp.prev != null) {
            temp.prev.next = null;
        } else {
            head = null;
        }
    }

    // Delete at a specific index
    public void deleteAtSpecificPosition(int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (index == 0) {
            deleteAtStart();
            return;
        }
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < index) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            System.out.println("Index out of bound");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Print the List
    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node currentNode = head;
        Node last = null;

        // System.out.print("Forward: head <-> ");
        System.out.print("Head <-> ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " <-> ");
            last = currentNode;  // Store last node for reverse traversal
            currentNode = currentNode.next;
        }
        System.out.println("NULL");

//     // Print in Reverse
//     System.out.print("Reverse: NULL <-> ");
//     while (last != null) {
//         System.out.print(last.data + " <-> ");
//         last = last.prev;
//     }
//     System.out.println("head");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Insert At Start");
        list.printList();
        list.InsertAtStart(4);
        list.printList();
        list.InsertAtStart(3);
        list.printList();
        list.InsertAtStart(2);
        list.printList();
        list.InsertAtStart(1);
        list.printList();
        System.out.println();

        System.out.println("Insert At End");
        list.insertAtEnd(4);
        list.printList();
        list.insertAtEnd(3);
        list.printList();
        list.insertAtEnd(2);
        list.printList();
        list.printList();

        System.out.println("Insert At Specific Index");
        list.insertAtSpecificIndex(5, 5);
        list.printList();
        list.insertAtSpecificIndex(5, 0);
        list.printList();
        list.insertAtSpecificIndex(1, 2);
        list.printList();

        System.out.println("Delete Node At Start");
        list.insertAtEnd(1);
        list.printList();
        list.deleteAtStart();
        list.printList();
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.printList();
        list.deleteAtStart();
        list.printList();

        System.out.println("Delete Node At End");
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.printList();
        list.deleteAtEnd();
        list.printList();
        list.deleteAtEnd();
        list.printList();
        list.deleteAtEnd();
        list.printList();

        System.out.println("Delete Node At Specific Index");
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.printList();
        list.deleteAtSpecificPosition(2);
        list.printList();
        list.deleteAtSpecificPosition(0);
        list.printList();

    }
}
