package Bit_Manupulation;
import java.util.*;
public class Minimum_Bit_Flips {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a=sc.nextInt();
        System.out.println("Enter the second number: ");
        int b=sc.nextInt();
        int result=minFlips(a,b);
        System.out.println("The minimum number of bit flips required to convert "+a+" to "+b+" is: "+result);
    }
    public static int minFlips(int a,int b){
        int xor=a^b;
        int count=0;
        while(xor>0){
            count+=xor&1;
            xor>>=1;
        }
        return count;
    }
}
