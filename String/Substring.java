public class Substring {
    public static String substring(String strr,int si,int ei){
       String strm="";
        for(int i=0;i<ei;i++){
            strm +=strr.charAt(i);
           

        }
        return strm;
    }
    public static void main(String[] args) {
        // JAVA HAS A DEFULT FUNCTION FOR SUBSTRING
        String str="HelloWold";
        System.out.println(substring(str,0,5));
        
        //System.out.println(substring(strr, 0,5));
    }
}
