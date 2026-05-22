import java.util.*;
public class CerryPickup_2 {
    static int n,m;
    public static int memoization(int[][] grid,int r1,int c1,int c2,int[][][] dp){
        if(c1>=m || c2>=m ||c1 <0 || c2<0 ){
            return -(int)1e8;
        }
        if(r1==n-1){
            if(c1==c2){
                return grid[r1][c1];
            }else{
                return grid[r1][c1]+grid[r1][c2];
            }
        }
        if(dp[r1][c1][c2]!=-1){
            return dp[r1][c1][c2];
        }
        
        int ans=Integer.MIN_VALUE;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int value=0;
                if(c1==c2){
                    value=grid[r1][c1];
                }else{
                    value=grid[r1][c1]+grid[r1][c2];
                }
                ans=Math.max(ans,value+memoization(grid,r1+1,c1+i,c2+j,dp));
            }
        }
        return dp[r1][c1][c2]=ans;
    }
    //    Memoization Approach:
    //                          Time Complexity: O(n*m*m)
    //                          Space Complexity: O(n*m*m) + O(n) for recursion stack
    public static int tabulation(int[][] grid){
        
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // base case
        for(int c1 = 0; c1 < m; c1++) {

            for(int c2 = 0; c2 < m; c2++) {

                if(c1 == c2) {
                    dp[n-1][c1][c2] = grid[n-1][c1];
                } else {
                    dp[n-1][c1][c2] =
                        grid[n-1][c1] + grid[n-1][c2];
                }
            }
        }

        return buildDP(grid, dp);
    }

    public static  int buildDP(int[][] grid, int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        for(int row = n-2; row >= 0; row--) {

            for(int c1 = 0; c1 < m; c1++) {

                for(int c2 = 0; c2 < m; c2++) {

                    int maxi = -(int)1e8;

                    for(int d1 = -1; d1 <= 1; d1++) {

                        for(int d2 = -1; d2 <= 1; d2++) {

                            int nc1 = c1 + d1;
                            int nc2 = c2 + d2;

                            int value = 0;

                            if(c1 == c2) {
                                value = grid[row][c1];
                            } else {
                                value =
                                    grid[row][c1] +
                                    grid[row][c2];
                            }

                            if(nc1 >= 0 && nc1 < m &&
                               nc2 >= 0 && nc2 < m) {

                                value +=
                                    dp[row+1][nc1][nc2];

                            } else {

                                value += -(int)1e8;
                            }

                            maxi = Math.max(maxi, value);
                        }
                    }

                    dp[row][c1][c2] = maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }
    //    Tabulation Approach:
    //                          Time Complexity: O(n*m*m*9) ~ O(n*m*m)
    //                          Space Complexity: O(n*m*m)

    public static void main(String[] args) {
        int[][] grid={{0,1,-1},{1,0,-1},{1,1,1}};
        System.out.println(tabulation(grid));
    }

}
