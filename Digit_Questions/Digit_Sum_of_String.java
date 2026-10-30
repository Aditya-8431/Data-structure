package Digit_Questions;
// Leetcode 2243 link  = "https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/"
public class Digit_Sum_of_String {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                int sum=0;
                for(int j=i;j<Math.min(i+k,s.length());j++){
                    sum+=s.charAt(j)-'0';
                }
                sb.append(sum);
            }
            s=sb.toString();

        }
        return s;
    }
    public static void main(String[] args) {
        Digit_Sum_of_String obj = new Digit_Sum_of_String();
        String s = "11111222223";
        int k = 3;
        String result = obj.digitSum(s, k);
        System.out.println(result); // Output: "135"
    }
}
