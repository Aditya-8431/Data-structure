import java.util.*;
public class WidthofBinaryTree {
    class Pair{
        int num;
        TreeNode node;
        public Pair(int num, TreeNode node){
            this.num = num;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().num;
            int first=0, last=0;
            for(int i=0; i<size; i++){
                Pair p=q.poll();
                int num=p.num-min;
                TreeNode node=p.node;
                if(i==0) first=num;
                if(i==size-1) last=num;
                if(node.left!=null){
                    q.offer(new Pair(num*2+1, node.left));
                }
                if(node.right!=null){
                    q.offer(new Pair(num*2+2, node.right));
                }
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
    }
}

// Time Complexity: O(N) where N is the number of nodes in the binary tree. 