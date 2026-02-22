package Graph_.DFS;
import java.util.*;

class Main {
    static int n, m;
    static char[][] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        g = new char[n][m];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = sc.next().charAt(0);

        int rooms = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (g[i][j] == '.') {
                    dfs(i, j);
                    rooms++;
                }

        System.out.println(rooms);
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
