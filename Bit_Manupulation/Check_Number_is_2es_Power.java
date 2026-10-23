package Bit_Manupulation;
import java.util.*;
public class Check_Number_is_2es_Power {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number");
        int n=sc.nextInt();
        boolean BruteForce=findPowerBrute(n);
        System.out.println("With BruteForce: "+ BruteForce);
        boolean Better=findPowerBetter(n);
        System.out.println("With Better: "+ Better);
        sc.close();
    }
    public static boolean findPowerBrute(int n){
        StringBuilder sb=new StringBuilder();
        while(n>=1){
            if(n%2!=0){
                sb.append('1');
            }else{
                sb.append('0');
            }
            n=n/2;
        }
        sb.reverse();
        int c=1;
        for(int i=0;i<sb.length();i++){
            if(c<0){
                return false;
            }else{
                if(sb.charAt(i)-'0'==1){
                    c--;
                }
            }
        }
        return true;
    }
    public static boolean findPowerBetter(int n){
        if(n==0){
            return false;
        }
        return (n&(n-1))==0;
    }

}
