package Bit_Manupulation;
import java.util.*;
public class Power_Set_Bit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList  <>();

        result=printPowerSet(arr);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+ " ");
        }
    }
    public static ArrayList<ArrayList<Integer>> printPowerSet(int[] arr){
        int n=arr.length;
        int subset=1<<n;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<subset;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    temp.add(arr[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
