package Bit_Manupulation;
import java.util.*;
public class Toggle_ith_Bit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number and the bit position to toggle");
        int n=sc.nextInt();
        System.out.println("Enter the bit position to toggle");
        int k=sc.nextInt();
        int result= toggleIthBit(n,k);
        System.out.println(result);
        sc.close();
    }
    public static int toggleIthBit(int n,int k){
        // Using Right Bit
        return (n^(1<<k));
        // Using Left Bit

        // return (n^(1<<k));
    }
}
