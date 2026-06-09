import java.io.*;
import java.util.*;

public class Round_Trip {

    static boolean found = false;
    static int cycleStart, cycleEnd;

    public static void main(String[] args) throws Exception {

        IO sc = new IO(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(parent, -1);

        for(int i = 1; i <= n; i++) {

            if(!vis[i]) {
                dfs(i, -1, adj, vis, parent);

                if(found) break;
            }
        }

        if(!found) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> cycle = new ArrayList<>();

        cycle.add(cycleStart);

        int cur = cycleEnd;

        while(cur != cycleStart) {
            cycle.add(cur);
            cur = parent[cur];
        }

        cycle.add(cycleStart);

        Collections.reverse(cycle);

        System.out.println(cycle.size());

        for(int x : cycle) {
            System.out.print(x + " ");
        }
    }

    static void dfs(int node,
                    int par,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis,
                    int[] parent) {

        vis[node] = true;

        for(int neigh : adj.get(node)) {

            if(neigh == par) continue;

            if(!vis[neigh]) {

                parent[neigh] = node;

                dfs(neigh, node, adj, vis, parent);

                if(found) return;
            }
            else {

                cycleStart = neigh;
                cycleEnd = node;

                found = true;
                return;
            }
        }
    }

    static class IO {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        IO(InputStream is) {
            in = is;
        }

        private int read() throws IOException {

            if(ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if(len <= 0) return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            while((c = read()) <= ' ') {
                if(c == -1) return -1;
            }

            int sign = 1;

            if(c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;

            while(c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}