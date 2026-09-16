package Bit_Manupulation;
import java.util.*;
public class Single_Number_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int result=singleNumber(arr);
        System.out.println("The single number is: "+result);
    }
    public static int singleNumber(int[] arr){
        int result=0;
        for(int i=0;i<arr.length;i++){
            result^=arr[i];
        }
        return result;
    }
}