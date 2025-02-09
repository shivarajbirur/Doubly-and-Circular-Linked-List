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

    // 1 - Insert at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 1 - Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        // if head has no node
        if (head == null) {
            insertAtStart(data);
            return;
        } else {
            // if head has some node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    // Insert at a specific index
    public void insertAtSpecificIndex(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);

        // If inserting at index 0 (start)
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        // Traverse to the node before the desired index
        while (temp != null && currentIndex < index - 1) {
            temp = temp.next;
            currentIndex++;
        }

        // if index is out of bounds
        if (temp == null) {
            System.out.println();
            System.out.println(" Index out of Bound");
            return;
        }

        // Insert the new node at the specific index
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delet tehe first node
    public void deleteAtFirst(){
        if(head == null){
            System.out.println("\n List is Already Empty");
            return;
        }

        head = head.next;
    }

    // Delet tehe End node
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("\n List is Already Empty");
            return;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at a specific index
    public void deleteAtSpecificPosition(int index) {
        if(index < 0){
            System.out.println("Invalid Index ");
            return;
        }
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(index == 0 ){
            deleteAtFirst();
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        while(temp.next != null && currentIndex < index - 1){
            temp = temp.next;
            currentIndex++;
        }

        if(temp.next == null){
            System.out.println("\n Index out of Bound");
            return;
        }

        temp.next = temp.next.next;

    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("\nList is empty");
            return;
        }

        Node currentNode = head;
        System.out.print("\n head --> ");

        while (currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(3);
        list.printList();
        list.insertAtStart(2);
        list.printList();
        list.insertAtStart(1);
        list.printList();

        list.insertAtEnd(300);
        list.printList();
        list.insertAtSpecificIndex(100, 0);
        list.printList();
        list.insertAtSpecificIndex(1000, 9);
        list.printList();
        list.insertAtSpecificIndex(300, 3);
        list.printList();


        System.out.println("\n Deleting first element:");
        list.deleteAtFirst();
        list.printList();

        System.out.println("\n Deleting last element:");
        list.deleteAtEnd();
        list.printList();

        System.out.println("\n Deleting element at position 2:");
        list.deleteAtSpecificPosition(2);
        list.printList();

        System.out.println("\n Deleting at an invalid index:");
        list.deleteAtSpecificPosition(10);
        list.printList();
    }
}
