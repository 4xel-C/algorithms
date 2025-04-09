package DataStructure;
public class RecursiveList<T> {

    private T head;
    private RecursiveList<T> tail;

    // Empty constructor
    public RecursiveList() {
        this.head = null;
        this.tail = null;
    }

    // Full constructor
    public RecursiveList(T element, RecursiveList<T> list) {
        this.head = element;
        this.tail = list;
    }

    // get head
    public T head() {
        return head;
    }

    // get tail
    public RecursiveList<T> tail() {
        return tail;
    }

    // get length
    public int length() {
        if (tail == null) return 1;

        return 1 + tail.length();
    }

    // add an element to the head
    public void addHead(T e) {

        // If we have an empty list, update the head
        if (this.head == null) {
            this.head = e;
            return;
        }
        
        this.tail = new RecursiveList<>(this.head, this.tail);
        this.head = e;
    }

    // add an element to the end
    public void addEnd(T e) {

        // If the list is empty, add the element.
        if (this.head == null) {
            this.head = e;
            return;
        }

        // travel to the last element
        RecursiveList<T> cursor = this;

        while (cursor.tail != null) {
            cursor = cursor.tail;
        }

        cursor.tail = new RecursiveList<>(e, null);

    }


    // delete the first element of the list
    public void deleteHead() {
        this.head = tail.head();
        this.tail = tail.tail();
    }

    // delete the last element of the list
    public void deleteLast() {

        // If th list have only 1 element
        if (this.tail == null) {
            this.head = null;
            return;
        }

        RecursiveList<T> cursor = this;

        while (cursor.tail.tail != null) {
            cursor = cursor.tail;
        }

        // Last before one element's tail point to null
        cursor.tail = null;

    }

    // Print the list
    public void print() {
        if (this.tail == null) {
            System.out.println(head);
            return;
        }

        System.out.print(head + " ");
        this.tail.print();
    }

    // Testing the function
    public static void main(String[] args) {

        // Creation of a recursive list
        RecursiveList<Integer> list = new RecursiveList<>();

        list.addHead(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addHead(0);
        list.print();
        list.deleteHead();
        list.print();
        list.deleteLast();
        list.print();
        System.out.println("Length: " + list.length());
        System.out.println("head: " + list.head());
        System.out.println("tail: " + list.tail().head());
    }

}
