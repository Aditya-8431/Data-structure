package Graph_.BFS;
import java.io.*;
import java.util.*;

public class Massage_Route {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    parent[nei] = node;
                    q.add(nei);
                }
            }
        }

        if (!vis[n]) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }

        Collections.reverse(path);

        System.out.println(path.size());
        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}