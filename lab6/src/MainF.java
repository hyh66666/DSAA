import java.util.Scanner;

public class MainF {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        char[] cipher=new char[26];
        for (int i = 0; i < cipher.length; i++) {
            cipher[i] =in.next().charAt(0) ;
        }
        String s= in.next();
        String temp = null,temp1 = null;
        if(s.length()%2==1) {
            temp = s.substring(0, s.length() / 2 + 1);
            temp1 = s.substring(s.length() / 2 + 1);
        }
        if(s.length()%2==0){
            temp = s.substring(0, s.length() / 2);
            temp1 = s.substring(s.length() / 2);
        }
        char[] last=new char[temp1.length()];
        for (int i = 0; i < temp1.length(); i++) {
            last[i]=cipher[temp1.charAt(i)-'a'];
        }
        int[] next=next(temp);
        int q=0;
        for (char c : last) {
            while (q > 0 && temp.charAt(q) != c) {
                q = next[q - 1];
            }
            if (temp.charAt(q) == c) {
                q += 1;
            }
        }
        System.out.println(s.length()-q);


    }
    public static int[] next(String s){
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
        return next;
    }
}
