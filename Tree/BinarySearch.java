public class BinarySearch { 
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this .data=data;
        }
    }
    public static Node insert(Node root ,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);

        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static Node delet(Node root ,int val){
        if(root.data<val){
            root.right=delet(root.right, val);
        }
        else if(root.data>val){
            root.left=delet(root.left, val);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;

            }
            
            Node is= findinordersucceror(root.right);
            root.data=is.data;
             root.right=delet(root.right, val);
            
        }
        return root;
    }
    public static Node findinordersucceror(Node root){
        while(root.left!=null){
            root=root.left;
        } 
        return root;   
    }

    public static void main(String[] args) {
        int val [] ={5,1,3,4,2,7,};
        Node root=null;
        for(int i=0; i<val.length;i++){
            root=insert(root, val[i]);
        }
        inorder(root);
        System.out.println();
        if(search(root, 7)){
            System.out.println("key is found");
        }else{
            System.out.println("not found");
        }
    }
    
}
