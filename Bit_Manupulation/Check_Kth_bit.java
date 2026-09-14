package Bit_Manupulation;
import java.util.*;
public class Check_Kth_bit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number and the bit position to check");
        int n=sc.nextInt();
        System.out.println("Enter the bit position to check");
        int k=sc.nextInt();
        boolean result= findIthBitSet(n,k);
        System.out.println(result);
    }
    public static boolean findIthBitSet(int n,int k){
        // Using Right Bit
        if(((n>>k)&1)!=0){
            return true;
        }else{
            return false;
        }
        // Using Left Bit

        // if(((1<<k) & n) !=0){
        //     return true;
        // }else{
        //     return false;
        // }
    }
}
