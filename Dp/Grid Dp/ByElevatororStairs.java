import java.io.*;
import java.util.*;
// CodeForces problem 1249E

public class ByElevatororStairs {
   

   public static void main(String[] args) {
      IO in = new IO();

      int n = in.nextInt();
      int c = in.nextInt();

      int[] ai = new int[n];
      int[] bi = new int[n];

      for (int i = 1; i < n; i++) {
         ai[i] = in.nextInt();
      }

      for (int i = 1; i < n; i++) {
         bi[i] = in.nextInt();
      }

      long[][] dp = new long[n + 1][2];

      dp[1][0] = 0;
      dp[1][1] = c;

      for (int i = 2; i <= n; i++) {

         dp[i][0] = ai[i - 1] + Math.min(dp[i - 1][0], dp[i - 1][1]);

         dp[i][1] = Math.min(
               dp[i - 1][0] + c + bi[i - 1],
               dp[i - 1][1] + bi[i - 1]);
      }

      StringBuilder sb = new StringBuilder();

      for (int i = 1; i <= n; i++) {
         sb.append(Math.min(dp[i][0], dp[i][1])).append(" ");
      }

      System.out.print(sb.toString().trim());
   }
   


}

// This is a custom fast IO class for reading input and writing output
// efficiently in Java.
// It uses a buffer to read input and a PrintWriter for output.
// We use this class to handle large input and output efficiently, which is
// often necessary in competitive programming problems to avoid timeouts.
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

// -------------------Documentation-------------------
/*
 * Problem: Given n floors, and two arrays ai and bi representing the time taken
 * to use stairs and elevator respectively, and a cost c for using the elevator,
 * find the minimum time to reach each floor starting from the first floor.
 * Solution: We can use dynamic programming to solve this problem. We maintain a
 * dp array where dp[i][0] represents the minimum time to reach the i-th floor
 * using stairs, and dp[i][1] represents the minimum time to reach the i-th
 * floor using the elevator.
 * We can fill this dp array iteratively based on the given conditions and then
 * output the minimum time for each floor.
 * Time Complexity: O(n) - We iterate through the floors once to fill the dp
 * array.
 * Space Complexity: O(n) - We use a dp array of size n x 2
 */
