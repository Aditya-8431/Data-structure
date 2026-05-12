package Tree;
import java.util.*;
// Diameter of Binary Tree
// Time Complexity: O(n) where n is the number of nodes in the tree
// space Complexity: O(h) where h is the height of the tree
 class Solutions {
    static int temp;// This variable is used to store the maximum diameter found during the traversal of the tree.
    public static DiameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        height(root);
        return temp;
    }
    public static int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        temp = Math.max(temp, left + right);
        return Math.max(left, right) + 1;
    }
}
