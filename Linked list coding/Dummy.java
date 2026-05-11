public class Dummy {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void IndAny(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            addFirst(data);  // insert at the beginning
            return;
        }

        Node temp = head;
        int i = 0;

        while (i < index - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null || temp.next == null && i < index - 1) {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public static void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    // this Function is For Search recursively in Linkes List;
    public static int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int inz=helper(head.next, key);
        if(inz==-1){
            return -1;
        }
        return inz+1;
    }
    public static int recserach(int key){
        return helper(head,key);
    }

    public static void main(String[] args) {
        addFirst(0);
        addFirst(2);
        addFirst(3);
        addFirst(44);
        addFirst(88);
        IndAny(2, 9);  // insert 9 at index 2
        print();
        System.out.println( recserach(88));
       
    }
}