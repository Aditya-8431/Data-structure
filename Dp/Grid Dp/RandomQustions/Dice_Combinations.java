        /*
        Your task is to count the number of ways to construct sum n by throwing a dice one or more times. Each throw produces an outcome between 1 and  6.
        For example, if n=3, there are 4 ways:

        1+1+1
        1+2
        2+1
        3

        Input
        The only input line has an integer n.
        Output
        Print the number of ways modulo 10^9+7.
        Constraints

        1 <= n <= 10^6

        Example
        Input:
        3

        Output: 4
 */




package RandomQustions;
import java.util.*;
public class Dice_Combinations {
    static int num;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] dp=new int[n+1];
        dp[0]=1;
        num=n;
        

        System.out.println(fxn(n,dp));
    }
    public static int fxn(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int count=0;
        for(int i=1;i<=6;i++){
            if(n-i>=0){
                count+=fxn(n-i,dp);
            }
        }
        return dp[n]=count;
    }
}
   