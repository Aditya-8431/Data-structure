package Graph_.Dijkestra;
import java.util.*;
public class Minimum_Obstical {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int m = sc.nextInt();
      int n= sc.nextInt();
      
      int[][] grid = new int[m][n];
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            grid[i][j] = sc.nextInt();
         }
      }
      System.out.println(minObstacles(grid));
   } 
   public static int minObstacles(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dr={-1,0,1,0};
        int[] dc={0,-1,0,1};
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int temp[]=pq.poll();
            int i=temp[1];
            int j=temp[2];
            int cost=temp[0];
            if(cost>dist[i][j]) continue;
            if(i==m-1 && j==n-1) return  cost;
            for(int k = 0; k < 4; k++) {
                int nr = i + dr[k];
                int nc = j + dc[k];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    
                    if(newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{newCost, nr, nc});
                    }
                }
            }
           
        }
         return -1;
   }
}
