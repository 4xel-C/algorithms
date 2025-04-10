package DataStructure;

public class LinkedList {

    // inner class for nodes
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Add a new node at the end of the list.
    public void append(int data) {

        Node newNode = new Node(data);

        // If linked list empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert a new node at the begining of the list
    public void addFirst(int data) {

        Node newNode = new Node(data);

        // If linked list empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        head = newNode;
        newNode.next = current;
    }

    // delete and return the last item of the list
    public int pop() {

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = null;

        return data;
    }

    // delete the first item of the list
    public void deleteFirst() {
        head = head.next;
    }

    public int length() {
        // If linked list empty
        if (head == null) {
            return 0;
        }

        Node current = head;
        int len = 1;

        while (current.next != null) {
            current = current.next;
            len++;
        }
        return len;
    }
}
