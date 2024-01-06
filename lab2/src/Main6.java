import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        int[]a=new int[n];
        int[]b=new int[n];
        int[][]th=new int[c][2];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]=in.nextInt();
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                th[i][j]=in.nextInt();
            }
        }
        for (int i = 0; i < c; i++) {
            int j = th[i][0] - 1,k =th[i][1] - 1;


            int star1=j,end1=k,star2=j,end2=k;
            boolean flag = true;
            while (star1<end1){
               int length=(end1 - star1 + 1)/2;
                int mid1=star1+(end1-star1)/2,mid2=star2+(end2-star2)/2;
                if(a[mid1]== b[mid2]){
                    System.out.println(a[mid1]);
                    flag = false;
                    break;
                }
                if(a[mid1]< b[mid2]){
                    star1=star1+length;
                    end2=end2-length;
                }
                if(a[mid1]> b[mid2]){
                    end1=end1-length;
                    star2=star2+length;
                }
            }
            if(flag) {
                System.out.println(Math.min(a[star1], b[star2]));
            }

        }
    }
}
