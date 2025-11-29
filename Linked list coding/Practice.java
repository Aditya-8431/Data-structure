public class Practice {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;

        }
    }
    public static Node head;
    public static Node tail;
    public static void addfirst(int data){
        Node n=new Node(data);
        if(head==null){
            head=tail=n;
        }else{ 
            n.next=head;
            head=n;
        }
    }
    public static void print(){
        if(head==null){
            System.out.println("LinkedList is empty: ");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void reverse(){
        
        Node prev=null;
        Node curr=tail=head;
        Node nex;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        head=prev;
    }
    public static void main(String[] args) {
        Practice pl=new Practice();
        pl.addfirst(12);
        pl.addfirst(23);
        pl.addfirst(43);
        pl.addfirst(56);
        pl.print();
        pl.reverse();
        pl.print();
        
    }
}
