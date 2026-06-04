package Dp.LIS;
import java.util.*;
public class CountLIS {
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
        System.out.println("Count of LIS:" + " "+tabulation(arr));
    }
    
    
    public static int tabulation(int[] arr){
       
        int[] dp=new int[n];
        int[] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                    else if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                }
            }
            ans=Math.max(ans,dp[i]);

        }
        int totalCount=0;
        for(int i=0;i<n;i++){
            if(dp[i]==ans){
                totalCount+=count[i];
            }
        }
        return totalCount;
    }

    
}