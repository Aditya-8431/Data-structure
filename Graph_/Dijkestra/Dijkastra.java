package Graph_.Dijkestra;
import java.io.*;
import java.util.*;

public class Dijkastra {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});  
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[1] = 0;
        parent[1] = -1;
        pq.add(new long[]{0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d != dist[u]) continue;

            for (long[] edge : adj.get(u)) {
                int v = (int) edge[0];
                long w = edge[1];

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }

        if (dist[n] == Long.MAX_VALUE) {
            out.println(-1);
            out.close();
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int curr = n;

        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);

        for (int node : path) {
            out.print(node + " ");
        }

        out.println();
        out.close();
    }
}