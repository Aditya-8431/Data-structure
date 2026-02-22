package Graph_.DFS;
import java.util.*;

public class TheLakeCf {

    static int n, m;
    static int[][] grid;
    static boolean[][] vis;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            n = sc.nextInt();
            m = sc.nextInt();

            grid = new int[n][m];
            vis = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int ans = 0;

            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 0 && !vis[i][j]) {
                        ans = Math.max(ans, bfs(i, j));
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static int bfs(int sr, int sc) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;

        int sum = grid[sr][sc];

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                        && grid[nr][nc] != 0 && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    sum += grid[nr][nc];
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return sum;
    }
}
