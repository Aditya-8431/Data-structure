import java.util.*;
import java.io.*;

public class K_Modification {
    public static void main(String[] args) {
        IO sc = new IO();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int[][][] dp = new int[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 0; l <= k; l++) {

                    dp[i][j][l] = Math.max(dp[i - 1][j][l], dp[i][j - 1][l]);

                    if (a[i - 1] == b[j - 1]) {
                        dp[i][j][l] = Math.max(dp[i][j][l],
                                1 + dp[i - 1][j - 1][l]);
                    } else if (l > 0) {
                        dp[i][j][l] = Math.max(dp[i][j][l],
                                1 + dp[i - 1][j - 1][l - 1]);
                    }
                }
            }
        }
        System.out.println(dp[n][m][k]);
    }
}

class IO extends PrintWriter {
    private InputStream in;
    private byte[] buf = new byte[65536];
    private int head = 0;
    private int tail = 0;

    public IO() {
        super(new BufferedOutputStream(System.out));
        this.in = System.in;
    }

    private int read() {
        if (this.head >= this.tail) {
            this.head = 0;

            try {
                this.tail = this.in.read(this.buf, 0, this.buf.length);
            } catch (IOException var2) {
                var2.printStackTrace();
            }

            if (this.tail <= 0) {
                return -1;
            }
        }

        return this.buf[this.head++];
    }

    public int nextInt() {
        int var1;
        for (var1 = this.read(); var1 <= 32; var1 = this.read()) {
            if (var1 == -1) {
                return -1;
            }
        }

        boolean var2 = false;
        if (var1 == 45) {
            var2 = true;
            var1 = this.read();
        }

        int var3;
        for (var3 = 0; var1 > 32; var1 = this.read()) {
            if (var1 >= 48 && var1 <= 57) {
                var3 = var3 * 10 + var1 - 48;
            }
        }

        return var2 ? -var3 : var3;
    }

    public char nextChar() {
        int var1;
        for (var1 = this.read(); var1 <= 32; var1 = this.read()) {
            if (var1 == -1) {
                return (char) -1;
            }
        }

        return (char) var1;
    }
}