import java.util.*;
class Solution {
    int n,m;
    public int minFallingPathSum(int[][] mat) {
        // code here
        n=mat.length;
        m=mat[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            dp[0][i]=mat[0][i];
        }
        for(int i=1;i<n;i++){
            int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                
                int down=dp[i-1][j];
                if(j-1>=0){
                    left=dp[i-1][j-1];
                }
                if(j+1<m){
                    right=dp[i-1][j+1];
                }
                    
                dp[i][j]=mat[i][j]+Math.min(left,Math.min(down,right));
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            mini=Math.min(dp[n-1][i],mini);
        }
        return mini;
        
    }
    public int memoization(int[][] mat,int i,int j,int[][] dp){
        if(i==n-1){
            return mat[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        int down=memoization(mat,i+1,j,dp);
        if(j-1>=0){
            left=memoization(mat,i+1,j-1,dp);
        }
        if(j+1<m){
            right=memoization(mat,i+1,j+1,dp);
        }
            
        return dp[i][j]=mat[i][j]+Math.min(left,Math.min(down,right));
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][] mat={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(s.minFallingPathSum(mat));
    }
    //  
    //     Memoization Approach: 
    //                          Time Complexity: O(n*m)
    //                          Space Complexity: O(n*m) + O(n) for recursion stack
        
    //     Tabulation Approach:
    //                          Time Complexity: O(n*m)
    //                          Space Complexity: O(n*m)
    // 
    
    
    
}

