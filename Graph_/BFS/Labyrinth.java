package Graph_.BFS;
import java.util.*;
public class Labyrinth {
    // Take buffer reader for submiting in CSES;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        int srow = 0;
        int scol=0;
        int drow=0;
        int dcol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextLine().charAt(0);
                if(grid[i][j]=='A'){
                    srow=i;
                    scol=j;

                }
                if(grid[i][j]=='B'){
                    drow=i;
                    dcol=j;
                }
            }
        }
        boolean[][] vis=new boolean[n][m];
        char[][] parent=new char[n][m];
        boolean found=false;
         int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        char[] dir = {'U', 'R', 'D', 'L'};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] { srow,scol});
        vis[srow][scol]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            if(r==drow && c==dcol){
                found=true;
                break;
            }
            for(int k=0;k<4;k++){
                int nr=dr[k]+r;
                int nc=dc[k]+c;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        !vis[nr][nc] && grid[nr][nc] != '#') {

                    vis[nr][nc] = true;
                    parent[nr][nc] = dir[k];
                    q.add(new int[]{nr, nc});
                }
            }
        }
        if(!found){
            System.out.println("NO");
            return;
        }
        StringBuilder sb=new StringBuilder();
        int r=drow;int c=dcol;
        while(r!=srow && c!=scol){
            sb.append(parent[r][c]);
            if(parent[r][c]=='U') r++;
            if(parent[r][c]=='D') r--;
            if(parent[r][c]=='L') c++;
            if(parent[r][c]=='R') c--;

        }
        System.out.println(sb.length());
        sb.reverse();
        System.out.println(sb.toString());

    }
}
