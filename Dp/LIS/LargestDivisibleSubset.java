package Dp.LIS;
import java.util.*;
public class LargestDivisibleSubset {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp=largestDivisibleSubset(arr);
        for(int i:temp){
            System.out.print(i+" ");
        }
    }
    public static ArrayList<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        if(n==0) return new ArrayList<>();

        Arrays.sort(arr);
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            for(int j = 0; j < i; j++) {
                if((arr[i] % arr[j] == 0 || arr[j]% arr[i]==0) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }

        int maxIndex = 0;
        for(int i = 1; i < n; i++) {
            if(dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(parent[maxIndex] != maxIndex) {
            result.add(arr[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        result.add(arr[maxIndex]);
        Collections.reverse(result);
        return result;
    }
}
