
import java.util.*;
import java.io.*;
public class RemovingDigits {
    
    public static void main(String[] args) throws IOException{
        IO sc=new IO(System.in);
        int n=sc.nextInt();
        int x=fxn(n);
        System.out.println(x);
    }
    public static int fxn(int n){
        if(n==0) return 0;
        String s=String.valueOf(n);
         int maxi=-1;
        for(int i=0;i<s.length();i++){
                maxi=Math.max(maxi,s.charAt(i)-'0');
            
        }
        return 1+fxn(n-maxi);
    }

}
class IO extends PrintWriter {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int bufferPointer = 0, bytesRead = 0;

    public IO(InputStream in) {
        super(new BufferedOutputStream(System.out));
        this.in = in;
    }

    private void fillBuffer() throws IOException {
        bytesRead = in.read(buffer, bufferPointer = 0, buffer.length);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    public int nextInt() throws IOException {
        int c, sgn = 1;
        while ((c = read()) <= ' ') if (c == -1) return -1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res = res * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return res * sgn;
    }

    public String next() throws IOException {
        int c;
        while ((c = read()) <= ' ') if (c == -1) return null;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = read()) > ' ');
        return sb.toString();
    }
}
