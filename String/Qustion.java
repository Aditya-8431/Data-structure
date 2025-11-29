// check string pelindrome;
public class Qustion {
    public static void main(String[] args) {
         String str= "amanaplanacanalpanama";
         System.out.println(check(str));
    }
    public static boolean check(String str){
        
        for(int i=0; i<str.length()/2;i++){
        int n=str.length();
            if(str.charAt(i)!=str.charAt(n-1-i)){

            
            return false;
            }
        }
        return true;

    }
}
