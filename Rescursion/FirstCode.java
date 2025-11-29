class Recurssion{

    public static void printInc(int a){
        if(a==1){
            System.out.print(a+ " ");
            return;
        }
        printInc(a-1);
        System.out.print(a + " ");
    }
    public static void printDec(int a){
        if(a==1){
            System.out.print(a +" ");
            return;
        }
        System.out.print(a+ " ");
        printDec(a-1);
    }
    // Finding factorial with recursive appoech
    public static int Facto(int n){
        if(n==0){
            return 1;
        }
        Facto(n-1);
        int fmn=n*Facto( n-1);
        return fmn;
    }
    //FInding sum of givien number with recursive apporch ;
    public static int Sum(int n){
        if(n==0){
            return 1;
        }
        Sum(n-1);
        int Smn=n+Sum(n-1);
        return Smn;
    }
    //Finding the fibonicci numbers with recursion;
    public static int Facbonacci(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;

        }
        int fab1=Facbonacci(n-1);
        int fab2=Facbonacci(n-2);
        int sum= fab1+ fab2;
        return sum;
    }
    public static int firstOccurence(int arr[],int key,int i){
        if(i==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        
        int a= firstOccurence(arr, key, i+1);
        
        return a;
    }
public static int lastOccurence(int arr[], int key,int i){
         if(i==arr.length){
          return -1;
     }
          int found=  lastOccurence(arr, key, i+1);
     if(found==-1 && arr[i]==key){
        return i;
     }
     return found;
}
    public static void main(String[] args) {
        int a=10;
        printInc(a);
        System.out.println(" ");
        printDec(a);
        int arr[]={2,5,4,9,5,6,4,8,9,1,6,8,6,9,};
        System.out.println();
        System.out.println(Sum(a));
        System.out.println(Facto(5));
        System.out.println(firstOccurence(arr ,5, 0));
        System.out.println(lastOccurence(arr, 9, 0));
            
        
    }
}