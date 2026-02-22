package Graph_.Dijkestra;
import java.util.*;
import java.io.*;

public class Sortest_Path {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{v, weight});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dis[0] = 0;
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int currdist = temp[0];
            int currnode = temp[1];

            if (currdist > dis[currnode]) continue;

            for (int[] x : adj.get(currnode)) {
                int newnode = x[0];
                int newweight = x[1];

                if (dis[currnode] + newweight < dis[newnode]) {
                    dis[newnode] = dis[currnode] + newweight;
                    pq.add(new int[]{dis[newnode], newnode});  
                }
            }
        }

       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dis[i]).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}
