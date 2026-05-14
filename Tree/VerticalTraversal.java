
import java.util.*;
public class VerticalTraversal{
    class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int row, int col) {
        this.node = _node;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple t = q.poll();

            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            if (!map.containsKey(row)) {
                map.put(row, new TreeMap<>());
            }

            if (!map.get(row).containsKey(col)) {
                map.get(row).put(col, new PriorityQueue<>());
            }

            map.get(row).get(col).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, row - 1, col + 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> lis = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> x : map.values()) {

            List<Integer> temp = new ArrayList<>();

            for (PriorityQueue<Integer> pq : x.values()) {

                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            lis.add(temp);
        }

        return lis;
    }

        public static void main(String[] args) {
            Solution sol = new Solution();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            List<List<Integer>> result = sol.verticalTraversal(root);
            System.out.println(result); // Output: [[9], [3, 15], [20], [7]]
        }
}
}