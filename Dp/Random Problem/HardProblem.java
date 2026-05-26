

import java.util.*;

public class HardProblem {
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cost = new long[n];
        String[] in = new String[n];
        String[] rev = new String[n];

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            in[i] = sc.next();
            rev[i] = reverse(in[i]);
        }

        long[][] dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = cost[0];

        for (int i = 1; i < n; i++) {
            if (in[i].compareTo(in[i - 1]) >= 0 && dp[i - 1][0] != Long.MAX_VALUE)
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
            if (in[i].compareTo(rev[i - 1]) >= 0 && dp[i - 1][1] != Long.MAX_VALUE)
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);


            if (rev[i].compareTo(in[i - 1]) >= 0 && dp[i - 1][0] != Long.MAX_VALUE)
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + cost[i]);
            if (rev[i].compareTo(rev[i - 1]) >= 0 && dp[i - 1][1] != Long.MAX_VALUE)
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + cost[i]);
        }

        long ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}