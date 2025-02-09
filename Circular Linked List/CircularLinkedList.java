class CircularLinkedList{

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }

    private Node head;
    private Node tail;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }


    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        } 
        else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Insert At End
    public void insertAtEnd(int data) {
        Node newnNode = new Node(data);
        if(head == null){
            insertAtStart(data);    
            return;
        }
        tail.next = newnNode;
        tail = newnNode;
        tail.next = head;
    }


    // Insert At Specific Index
    public void insertAtSpecificIndex(int data, int index) {
        if(index < 0){
            System.out.println("Invalid index");
            return;
        }

        if(index ==0){
            insertAtStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int currentIndex=0;

        while(temp.next !=head && currentIndex < index - 1){
            temp = temp.next;
            currentIndex++;
        }
        if(currentIndex < index - 1){
            System.out.println("Index out bound ");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if(temp == tail){
            tail = newNode;
        }
    }

    // Delete at Start
    public void deleteAtStart() {
        if(head == null){
            System.out.println("List is already empty");
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

     // Delete at End
     public void deleteAtEnd() {
        if(head == null){
            System.out.println("List is already empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    // Delete at Specific Index
    public void deleteAtSpecificPosition(int index) {
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if (index == 0) {
            deleteAtStart();
            return;
        }
        Node temp = head;
        int currentIndex = 0;

        while(temp.next != head && currentIndex < index -1){
            temp = temp.next;
            currentIndex++;
        }

        if(temp.next == head || currentIndex < index - 1){
            System.out.println("index out of Bound");
            return;
        }
        temp.next = temp.next.next;
        if(temp.next == head){
            tail = temp;
        }

    }

    // Print the List
    public void printList() {
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Head -> ");
        do { 
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head );
        System.out.println("Head");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        System.out.println("Insert At Start");
        list.printList();
        list.insertAtEnd(100);
        list.printList();
        list.insertAtStart(10);
        list.printList();
        list.insertAtStart(20);
        list.printList();
        System.out.println();

        System.out.println("Insert At End");
        list.insertAtEnd(5);
        list.printList();
        System.out.println();

        System.out.println("Insert At Specific Index");
        list.insertAtSpecificIndex(101, 0);
        list.printList();
        list.insertAtSpecificIndex(105, 5);
        list.printList();
        list.insertAtSpecificIndex(103, 3);
        list.printList();
        System.out.println();
        
        System.out.println("Delete At Start");
        list.deleteAtStart();
        list.printList();
        System.out.println();

        System.out.println("Delete At End");
        list.deleteAtEnd();
        list.printList();
        System.out.println();

        System.out.println("Delete At Specific Index");
        list.deleteAtSpecificPosition(0);
        list.printList();
        list.deleteAtSpecificPosition(3);
        list.printList();
        list.deleteAtSpecificPosition(1);
        list.printList();
    }   
}