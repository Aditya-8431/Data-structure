public class Qustions {
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
    public static int size;
      // method for Adding in first of linked list;
    public static void addFirst(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
       
        
        newNode.next=head;
        head=newNode;
    }
    public static void print(){
        if (head==null){
            System.out.println("LinkedList is empty");

        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + " ->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static Node getmid(){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node mergedsort(Node head){
        //find mid
        Node mid=getmid();
        Node righthead=mid.next;
        mid.next=null;
        Node newleft=mergedsort(head);
        Node newright=mergedsort(righthead);
        return merge(newleft,newright);
    }
    public Node merge(Node lefthead,Node righthead){
        Node mergedll=new Node(-1);
        Node temp=mergedll;
        while(lefthead !=null && righthead !=null){
            if(lefthead.data <=righthead.data){
                temp.next=lefthead;
                lefthead=lefthead.next;
                temp=temp.next;
            }else{
                temp.next=righthead;
                righthead=righthead.next;
                temp=temp.next;
            }
        }
        while (lefthead!=null) {
            temp.next=lefthead;
            lefthead=lefthead.next;
                temp=temp.next;
        }while (lefthead!=null) {
            temp.next=righthead;
             righthead=righthead.next;
                temp=temp.next;
        }
        
    
        return mergedll.next;
    }
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
          ll.addFirst(4);
         ll.addFirst(3);
         ll.addFirst(2);
         ll.addFirst(1);
         ll.addFirst(0);
         ll.print();
         ll.head=ll.mergedsort(ll.head);

    }

}