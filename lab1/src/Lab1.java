import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n,T;
        int c=0;
        n=in.nextInt();
        int [] a=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=in.nextInt();
        }
        T=in.nextInt();
        int []b=new int[T];
        for (int i = 0; i < b.length; i++) {
            b[i]=in.nextInt();
        }
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < n; j++) {
                    if(b[i]==a[j]){
                        c++;
                        break;
                    }
                }
                if(c==0){
                    System.out.println("no");
                }
                if(c>0){
                    System.out.println("yes");
                    c=0;
                }

            }


    }
}
