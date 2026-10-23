package Bit_Manupulation;

public class Remove_the_last_set_bit {
    public static void main(String[] args) {
        int n=12;
        System.out.println("Before removing the last set bit: "+n);
        int result=removeLastSetBit(n);
        System.out.println("After removing the last set bit: "+result);
    }
    public static int removeLastSetBit(int n){
        return (n&(n-1));
    }
}
