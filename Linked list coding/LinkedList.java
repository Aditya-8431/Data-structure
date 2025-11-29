import java.lang.classfile.components.ClassPrinter.ListNode;

public class LinkedList{
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
    public static void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        
            tail.next=newNode;
            tail =null;
    }
    public static void adInindex(int inx, int data){
        Node new_node =new Node(data);
        size++;
        Node temp=head;
        int i=0;
        if(inx==0){
            addFirst(data);
        }
        
        while(i<inx-1){ 
            temp=temp.next;
            i++;
        }
        new_node.next=temp.next;
        temp.next= new_node; 
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
    public static int removeFirst(){
        if(size==0){
            System.out.println("it is empty linked list");
            return Integer.MAX_VALUE;
        }
        else if(size==1){
            int val =head.data;
            head=tail=null;
            return val;

        }
        int val =head.data;
        head=head.next;
        size --;
        return val;

    }
    public static boolean isPalindron(){
        Node mid=getmid();
        Node righthead=mid.next;
        
        Node prev=null;
        Node curr=mid;
        Node Next;
        while (curr!=null){
            Next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        
        Node templ=head;
        Node tempr=prev;
        while(tempr !=null){
            if(templ.data!=tempr.data){
                return false;
            }
            templ=templ.next;
            tempr=tempr.next;
        }
        return true;
    }
    public static int removeLast(){
        if (size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if (size==1){
            int val =head.data;
            head=tail= null;
            
            return val;
        }
        Node prev= head;
        for (int i=0; i<size-2;i++){
            prev=prev.next;
            
        }
        int val =prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public static void merge(LinkedList l1, LinkedList l2){
        if(l1.head==null){
            head=l2.head;
            tail=l2.tail;
            return;
        }
        if(l2.head==null){
            head=l1.head;
            tail=l1.tail;
            return;
        }
        Node p1=l1.head;
        Node p2=l2.head;
        while(p1!=null && p2!=null){
            if(p1.data<p2.data){
                addLast(p1.data);
                p1=p1.next;
            }else{
                addLast(p2.data);
                p2=p2.next;
            }
        }
        while(p1!=null){
            addLast(p1.data);
            p1=p1.next;
        }
        while(p2!=null){
            addLast(p2.data);
            p2=p2.next;
        }
    }
    public static int search(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if (temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public static Node getmid(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node Next;
        while (curr!=null){
            Next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        head=prev;
    }
    // Check in a linklist cycle exist or not
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null & fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //Detecet the loop and remove the loop and cycle;

    public  static void detect_and_remove(){
        Node slow=head;
        Node fast=head;
          Node prev=null;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
            }

        }
        if(cycle==false){
            return;
        }else{
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                prev=fast;
                fast=fast.next;

            }
            prev.next=null;

        }
       
    }
    public static void Delect_m_n(int m,int n){
         Node temp=head;
            Node curr;
            int i=1;
        if(n==1){
           
            while(temp!=null){
                temp=temp.next;
                i++;
                if(i==m){
                    curr=temp;
                    curr.next=temp.next.next;
                    temp=temp.next.next;
                }
            }
        }else{
             while(temp!=null){
                temp=temp.next;
                i++;
                if(i==m){
                    curr=temp;
                    curr.next=temp.next.next.next;
                    temp=temp.next.next.next;
                }
            }
        }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode prev=head;
        if(n== size){
            head=head.next;
            return head;
        }
        int i=1;
        int inx=size-n;
        while(i<inx){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;

    }

    public static void main (String args []){
        LinkedList ll =new LinkedList();
        ll.addFirst(1);
         ll.addFirst(2  );
         ll.addFirst(3);
         ll.addFirst(4);
         ll.addFirst(5);
         ll.addFirst(6);
         ll.addFirst(7);

         //ll.Delect_m_n(3, 2);
         
         ll.print();
         LinkedList ll2 =new LinkedList();
         ll2.addFirst(1);
         ll2.addFirst(2);
         ll2.addFirst(3);
         ll2.addFirst(4);
         ll2.addFirst(5);
         ll2.addFirst(6);
         ll2.addFirst(9);
         ll.merge(ll,ll2);
         ll2.print();
         //adInindex(2, 50);
         //ll.removeFirst();
         //ll.removeLast();
         
         
         //System.out.println(ll.search(4));
         //System.out.println("This is palindron" +" " + ll.isPalindron());
    }
}

