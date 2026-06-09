import java.util.*;
import java.io.*;

public class Monsters {

    public static void main(String[] args) throws IOException {

        IO sc = new IO(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        int sx = -1, sy = -1;

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            for(int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);

                if(grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] dir = {'U', 'R', 'D', 'L'};

        int[][] monsterTime = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(monsterTime[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        // Multi-source BFS from all monsters
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 'M') {
                    q.add(new int[]{i, j});
                    monsterTime[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(grid[nx][ny] == '#')
                    continue;

                if(monsterTime[nx][ny] > monsterTime[x][y] + 1) {

                    monsterTime[nx][ny] = monsterTime[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        char[][] parent = new char[n][m];

        q.clear();

        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;

        int endX = -1;
        int endY = -1;

        // Special case: start already on boundary
        if(sx == 0 || sx == n - 1 || sy == 0 || sy == m - 1) {

            System.out.println("YES");
            System.out.println(0);
            System.out.println("");
            return;
        }

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(grid[nx][ny] == '#')
                    continue;

                if(dist[nx][ny] != -1)
                    continue;

                int newTime = dist[x][y] + 1;

                if(newTime >= monsterTime[nx][ny])
                    continue;

                dist[nx][ny] = newTime;
                parent[nx][ny] = dir[k];

                q.add(new int[]{nx, ny});

                if(nx == 0 || nx == n - 1 || ny == 0 || ny == m - 1) {

                    endX = nx;
                    endY = ny;

                    q.clear();
                    break;
                }
            }
        }

        if(endX == -1) {
            System.out.println("NO");
            return;
        }

        StringBuilder path = new StringBuilder();

        int x = endX;
        int y = endY;

        while(x != sx || y != sy) {

            char move = parent[x][y];

            path.append(move);

            if(move == 'U') {
                x++;
            }
            else if(move == 'D') {
                x--;
            }
            else if(move == 'L') {
                y++;
            }
            else { // R
                y--;
            }
        }

        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path);
    }
}

class IO {

    BufferedReader br;
    StringTokenizer st;

    public IO(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    public String next() throws IOException {

        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}