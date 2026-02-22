package Graph_.Dijkestra;
import java.io.*;
import java.util.*;

public class Course_Sedular {

    static int[] indegree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        indegree = new int[n + 1];

        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topoSort = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        
        StringBuilder sb = new StringBuilder();

        if (topoSort.size() == n) {
            for (int node : topoSort) {
                sb.append(node).append(" ");
            }
        } else {
            sb.append("IMPOSSIBLE");
        }

        System.out.println(sb);
    }
}
