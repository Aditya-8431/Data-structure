import java.util.*;

public class Pretravers {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class PreTree {
        static int idx = -1;

        public static Node buildTree(int data[]) {
            idx++;
            if (data[idx] == -1) {
                return null;
            }
            Node newnode = new Node(data[idx]);
            newnode.left = buildTree(data);
            newnode.right = buildTree(data);
            return newnode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            int level = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                System.out.print("Line-" + level + ": ");
                for (int i = 0; i < size; i++) {
                    Node currentdata = q.remove();
                    System.out.print(currentdata.data + " ");
                    if (currentdata.left != null) {
                        q.add(currentdata.left);
                    }
                    if (currentdata.right != null) {
                        q.add(currentdata.right);
                    }
                }
                System.out.println();
                level++;
            }
        }
        public static int  Height(Node root){
            if (root==null){
                return -1 ;
            }
            int lh=Height(root.left);
            int rh= Height(root.right);
            int h=Math.max(lh,rh) + 1;
            return h;


        }
    }

    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        PreTree t = new PreTree();
        Node root = t.buildTree(node);
        t.levelorder(root);
        System.out.println("hight of tree is : " + t.Height(root));
    }
}
