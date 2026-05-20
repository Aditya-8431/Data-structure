import java.util.*;
public class Main {

    

    static int n;
    static long W;
    static long[] w;
    static int[] v;

    static long[][] dp;

    static long INF = (long)1e18;

    static long solve(int i, int val) {

        // value achieved
        if (val == 0)
            return 0;

        // no items left
        if (i == n)
            return INF;

        if (dp[i][val] != -1)
            return dp[i][val];

        // not take
        long notTake = solve(i + 1, val);

        // take
        long take = INF;

        if (val >= v[i]) {
            take = solve(i + 1, val - v[i]) + w[i];
        }

        return dp[i][val] = Math.min(take, notTake);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        W = sc.nextLong();

        w = new long[n];
        v = new int[n];

        int totalValue = 0;

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextLong();
            v[i] = sc.nextInt();

            totalValue += v[i];
        }

        dp = new long[n + 1][totalValue + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;

        for (int val = totalValue; val >= 0; val--) {

            if (solve(0, val) <= W) {
                ans = val;
                break;
            }
        }

        System.out.println(ans);
    }


    
}
class FastReader {

    Scanner sc;

    FastReader() {
        sc = new Scanner(System.in);
    }

    int nextInt() {
        return sc.nextInt();
    }
}
