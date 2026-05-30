package Dp.LCS;
import java.util.*;
class Solution{
    static int n,m;
    public static void main(String[] args) {
        String s = "aa";
        String p = "aa";
        System.out.println(memoization(s, p));
    }
    public static boolean memoization(String s, String p) {
         n = s.length();
         m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return helper(s, p, n, m, dp);
    }
    public static boolean helper(String s, String p, int i, int j, Boolean[][] dp) {
        if(i==0 && j==0) return true;
        if(j==0) return false;
        if(i==0) {
            for(int k=1; k<=j; k++) {
                if(p.charAt(k-1) != '*') return false;
            }
            return true;
        }
        if(dp[i-1][j-1] != null) return dp[i-1][j-1];
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
            return dp[i-1][j-1] = helper(s, p, i-1, j-1, dp);
        }
        else if(p.charAt(j-1) == '*') {
            return dp[i-1][j-1] = helper(s, p, i, j-1, dp) || helper(s, p, i-1, j, dp);
        }
        
            return dp[i-1][j-1] = false;
        

    }
    public static boolean tabulation(String s, String p) {

     n = s.length();
     m = p.length();

    boolean[][] dp = new boolean[n + 1][m + 1];

    dp[0][0] = true;

    for(int i = 1; i <= n; i++) {
        dp[i][0] = false;
    }

    for(int j = 1; j <= m; j++) {
        boolean flag = true;

        for(int k = 1; k <= j; k++) {
            if(p.charAt(k - 1) != '*') {
                flag = false;
                break;
            }
        }

        dp[0][j] = flag;
    }

    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {

            if(s.charAt(i - 1) == p.charAt(j - 1)
                    || p.charAt(j - 1) == '?') {

                dp[i][j] = dp[i - 1][j - 1];
            }

            else if(p.charAt(j - 1) == '*') {

                dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }

            else {

                dp[i][j] = false;
            }
        }
    }

    return dp[n][m];
}
}
    

