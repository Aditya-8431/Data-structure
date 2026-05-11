import java.util.*;
class Solutions{
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
    
            TreeNode(int val) {
                this.val = val;
                this.left = null;
                this.right = null;
            }
        }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> tree = new ArrayList<>();
        if(root == null) return tree;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode currentNode = q.poll();
                if(flag){
                    level.add(currentNode.val);
                } else {
                    level.add(0, currentNode.val);
                }

                if(currentNode.left != null) q.offer(currentNode.left);
                if(currentNode.right != null) q.offer(currentNode.right);
            }
            tree.add(level);
            flag = !flag;
        }
        return tree;
    }
    public static void main(String[] args) {
        Solutions sol = new Solutions();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = sol.zigzagLevelOrder(root);
        System.out.println(result);
    }

}