import java.util.*;
public class BinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }

    }
    
    static class Tree{
        public static Node createTree(){
            Scanner sc=new Scanner(System.in);
            Node root=null;
            System.out.println("Enter your root: ");
            int data=sc.nextInt();
            if (data==-1){
                return null;
            }
            root=new Node(data);
            System.out.println("Enter left data for:" + data);
            root.left=createTree();
            System.out.println("enter right data for:" + data);
            root.right=createTree();

            return root;
        }

        public static void main(String[] args) {
           Tree t=new Tree();
           t.createTree();
        }
    }

}