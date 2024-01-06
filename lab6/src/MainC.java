import java.io.*;
import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int []next=new int[s.length()];
        int k=0;
        for (int i = 1; i <s.length(); i++) {
            while (k>0&&s.charAt(k)!=s.charAt(i)){
                k=next[k-1];
            }
            if(s.charAt(k)==s.charAt(i)){
                k+=1;
            }
            next[i]=k;
        }
        for (int i = 0; i < s.length(); i++) {
            out.println(next[i]);
        }
        out.flush();

    }
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
