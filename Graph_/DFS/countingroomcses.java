package Graph_.DFS;
import java.io.*;

class countingroomcses {
    static int n, m;
    static char[][] g;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);

        g = new char[n][m];
        int r = 0, c = 0;

        while (r < n) {
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '.' || ch == '#') {
                    g[r][c++] = ch;
                    if (c == m) { r++; c = 0; }
                }
            }
        }
        

        int rooms = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] == '.') {
                    dfs(i, j);
                    rooms++;
                }

        System.out.println(rooms);
    }
    static void printGrid(char[][] g) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || g[i][j] == '#') return;
        g[i][j] = '#';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
