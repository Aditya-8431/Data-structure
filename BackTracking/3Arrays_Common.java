import java.util.*;
class Solution{
    public static List<Integer> intersection(int arr1[],int arr2[],int arr3[]){
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<arr1.length &j<arr2.length &k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                ans.add(arr1[i]);
                i++;j++;k++;
            }else{
                if(arr1[i]<arr2[j] || arr1[i]<arr3[k]){
                    i++;
                }else if(arr2[j]<arr1[i]  || arr2[j]<arr3[k]){
                    j++;
                }else{
                    k++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int a1[]={5,10,20,30,40};
        int a2[]={1,3,4,5,20};
        int a3[]={0,1,2,5,20};
        List<Integer> store =new ArrayList<>();
        store=intersection(a1,a2,a3);
        System.out.println(store);
    }
}