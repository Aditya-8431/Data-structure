package Graph_.DFS;
import java.io.*;
import java.util.*;

public class Main_1 {

    public static ArrayList<Integer> dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
      ArrayList<Integer> component = new ArrayList<>();

        vis[u] = true;
        component.add(u);
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                dfs(v, adj, vis);
            }
        }
        return component;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m=fs.nextInt();   // number of nodes / points

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] == x[j] || y[i] == y[j]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int components = 0;
        ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
              dfs(i, adj, vis);
              allComponents.add(dfs(i, adj, vis));
                components++;

            }
        }

        // Codeforces expected output
        //System.out.println();
    }

    // Fast input class (Codeforces standard)
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
