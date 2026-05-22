import java.util.*;
public class CerryPickup {
    public static int memoization(int[][] grid,int r1,int c1,int r2,int[][][] dp){
            if(r1==grid.length-1 && c1==grid[0].length-1){
                return grid[r1][c1];
            }
            if(r1>=grid.length || c1>=grid[0].length || r2>=grid.length || c1>=grid[0].length){
                return Integer.MIN_VALUE;
            }
            if(dp[r1][c1][r2]!=-1){
                return dp[r1][c1][r2];
            }
            int cherries=0;
            if(r1==r2 && c1==c1){
                cherries+=grid[r1][c1];
            }else{
                cherries+=grid[r1][c1]+grid[r2][c1];
            }
            int ans=Integer.MIN_VALUE;
            ans=Math.max(
                Math.max(
                    memoization(grid,r1+1,c1,r2+1,dp),
                    memoization(grid,r1,c1+1,r2,dp)
                ),
                Math.max(
                    memoization(grid,r1+1,c1,r2,dp),
                    memoization(grid,r1,c1+1,r2+1,dp)
                )
                
            );
            return dp[r1][c1][r2]=cherries+ans;
    }
    //    Memoization Approach:
    //                          Time Complexity: O(n*n*n)
    //                          Space Complexity: O(n*n*n) + O(n) for recursion stack

    public static int tabulation(int[][] grid){
        int n=grid.length,m=grid[0].length;
        int[][][] dp=new int[n][m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        dp[0][0][0]=grid[0][0];
        for(int r1=0;r1<n;r1++){
            for(int c1=0;c1<m;c1++){
                for(int r2=0;r2<n;r2++){
                    if(r1==0 && c1==0 && r2==0){
                        continue;
                    }
                    int cherries=0;
                    int c2=r1+c1-r2;
                    if(c2<0 || c2>=m){
                        continue;
                    }
                    if(r1==r2 && c1==c2){
                        cherries+=grid[r1][c1];
                    }else{
                        cherries+=grid[r1][c1]+grid[r2][c2];
                    }
                    int ans=Integer.MIN_VALUE;
                    ans=Math.max(
                        Math.max(
                            r1-1>=0 && r2-1>=0 ? dp[r1-1][c1][r2-1] : Integer.MIN_VALUE,
                            c1-1>=0 && r2-1>=0 ? dp[r1][c1-1][r2-1] : Integer.MIN_VALUE
                        ),
                        Math.max(
                            r1-1>=0 && c2-1>=0 ? dp[r1-1][c1][r2] : Integer.MIN_VALUE,
                            c1-1>=0 && c2-1>=0 ? dp[r1][c1-1][r2] : Integer.MIN_VALUE
                        )
                        
                    );
                    dp[r1][c1][r2]=cherries+ans;
                }
            }
        }
        return Math.max(0,dp[n-1][m-1][n-1]);
    }
    //    Tabulation Approach:
    //                          Time Complexity: O(n*n*n)
    //                          Space Complexity: O(n*n*n)
    
    public static void main(String[] args) {
        int[][] grid={{0,1,-1},{1,0,-1},{1,1,1}};
        int[][][] dp=new int[grid.length][grid[0].length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        System.out.println(memoization(grid,0,0,0,dp));
    }
    

}
