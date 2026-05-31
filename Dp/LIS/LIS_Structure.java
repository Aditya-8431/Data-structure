package Dp.LIS;
import java.util.*;
public class LIS_Structure {
    static int n;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[][] dp=new int[n][n+1];
        for(int [] i:dp) Arrays.fill(i,-1);
        //System.out.println("LIS Tabulation:" + " "+tabulation(arr));
        System.out.println("LIS Memoization:" + " "+memoization(0,-1,arr,dp));
        ArrayList<Integer> temp=new ArrayList<>();
        temp=printLIS(arr);
        for(int i:temp){
            System.out.print(i+" ");
        }
    }
    public static int tabulation(int[] arr){
        int ni=arr.length;
        int[] dp=new int[ni];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<ni;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);

        }
        return ans;
    }
    
    public static int memoization(int i,int prev,int[] arr,int[][] dp){
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int ex=memoization(i+1,prev,arr,dp);
        int in=Integer.MIN_VALUE;
        if(  prev==-1 || arr[i]>arr[prev]){
            in=1+memoization(i+1,i,arr,dp);
        }
        return dp[i][prev+1]=Math.max(ex,in);
    }
    
    public static ArrayList<Integer> printLIS(int[] arr) {

        int n = arr.length;
        if(n==0) return new ArrayList<>();

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int maxLen = 1;
        int lastIndex = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < i; j++) {

                if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if(dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        while(parent[lastIndex] != lastIndex) {
            lis.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        lis.add(arr[lastIndex]);

        Collections.reverse(lis);

        return lis;
    }

}