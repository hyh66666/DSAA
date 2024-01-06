import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        char[] t=new char[s.length()*2+3];
        t[0]='$';
        for (int i = 0; i < s.length(); i++) {
            t[2*i+1]='#';
            t[2*i+2]=s.charAt(i);
        }
        t[s.length()*2+1]='#';
        t[s.length()*2+2]='!';
        int[] p=new int[s.length()*2+3];
        int max=0;
        int mid = 0, mx = 0;//mid 中心，mx右边界
        for (int i = 1; i < p.length-1; i++) {
            int j = 2*mid - i;//与i对称的点
            if(mx>i){
                p[i]=Math.min(mx-i,p[j]);
            }
            while (t[i+p[i]+1]==t[i-1-p[i]]){
                p[i]++;
            }
            if(i+p[i]>mx){
                mid=i;
                mx=i+p[i];
            }
            if(max<p[i]){
                max=p[i];
            }
        }
        System.out.println(max);


    }
}
