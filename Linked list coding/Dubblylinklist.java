public class Dubblylinklist {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public  void addFirst(int data){
        Node newNode= new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public  void print(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data + " <->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static int removeFirst(){
        if(head==null){
            System.out.println("empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val =head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head = head.next;
        head.prev=null;
        return val;
    }
    public static int removeLast(){
        Node temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        int k=temp.data;
        temp=temp.prev;
        temp.next=null;
        return k;
    }
    public static void reverse(){
        Node temp = head;
        Node prevNode = null;

    while (temp != null) {
        prevNode = temp;
        Node Next = temp.next;
        temp.next = temp.prev;
        temp.prev = Next;
        temp = Next;
    }

    head = prevNode;
    }
    public static void main (String [] args){
        Dubblylinklist dll =new Dubblylinklist();
        dll.addFirst(6);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);

        dll.addFirst(12);
        dll.addFirst(14);
        dll.print();
           //dll.removeLast();
           dll.reverse(); 
        dll.print();
    }

    
}
