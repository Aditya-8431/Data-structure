package Digit_Questions;

public class Decoding_Ways {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

           int num= Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Decoding_Ways decoder = new Decoding_Ways();
        String s = "226";
        int result = decoder.numDecodings(s);
        System.out.println("Number of ways to decode \"" + s + "\": " + result); // Output: 3
    }
}