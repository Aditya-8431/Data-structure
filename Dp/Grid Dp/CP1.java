// Leetcode 2435. Paths in Matrix Whose Sum Is Divisible by K
//link - https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/description/
import java.util.*;
class Solution {

    int MOD = (int)1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;


        // dp[row][col][remainder]
        int[][][] dp = new int[n][m][k];


        // Base Case: last cell
        for(int rem = 0; rem < k; rem++) {

            if((rem + grid[n-1][m-1]) % k == 0) {
                dp[n-1][m-1][rem] = 1;
            }
            else {
                dp[n-1][m-1][rem] = 0;
            }
        }


        // Fill table from bottom-right to top-left
        for(int i = n-1; i >= 0; i--) {

            for(int j = m-1; j >= 0; j--) {


                // already calculated base case
                if(i == n-1 && j == m-1)
                    continue;


                for(int oldRem = 0; oldRem < k; oldRem++) {


                    // after adding current cell
                    int newRem = (oldRem + grid[i][j]) % k;


                    int down = 0;
                    int right = 0;


                    // move down
                    if(i + 1 < n) {
                        down = dp[i+1][j][newRem];
                    }


                    // move right
                    if(j + 1 < m) {
                        right = dp[i][j+1][newRem];
                    }


                    dp[i][j][oldRem] = (down + right) % MOD;

                }
            }
        }


        return dp[0][0][0];
    }
}