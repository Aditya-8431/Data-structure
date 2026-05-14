
import java.util.*;
public class View {
    class Pair {
        TreeNode node;
        int hd;

        public Pair(TreeNode _node, int _hd) {
            this.node = _node;
            this.hd = _hd;
        }
    }
    class Solution{
        public List<Integer> topView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair (root, 0));
            while(!q.isEmpty()){
                Pair p = q.poll();
                TreeNode node = p.node;
                int hd = p.hd;
                if(!map.containsKey(hd)){
                    map.put(hd, node.val);
                }
                if(node.left != null){
                    q.offer(new Pair(node.left, hd - 1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, hd + 1));
                }
            }
            for(int key : map.keySet()){
                ans.add(map.get(key));
            }
            return ans;
        }
        public List<Integer> bottomView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));
            while(!q.isEmpty()){
                Pair p = q.poll();
                TreeNode node = p.node;
                int hd = p.hd;
                map.put(hd, node.val);
                if(node.left != null){
                    q.offer(new Pair(node.left, hd - 1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, hd + 1));
                }
            }
            for(int key : map.keySet()){
                ans.add(map.get(key));
            }
            return ans;
        }
        public List<Integer> leftView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();
                    if(i == 0){
                        ans.add(node.val);
                    }
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }
            }
            return ans;
        }
        public List<Integer> rightView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();
                    if(i == size - 1){
                        ans.add(node.val);
                    }
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }
            }
            return ans;
        }
    }
}
