import java.util.Random;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=5;
        int c=2;
        int[]a=new int[n];
        int[]b=new int[n];
        Random random = new Random();
        int[][]th=new int[c][2];
        for (int i = 0; i < n; i++) {
            a[i]=random.nextInt(10);
        }
        for (int i = 0; i < n; i++) {
            b[i]= random.nextInt(10);
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                th[i][j]= random.nextInt(6);
            }
        }
        for (int i = 0; i < c; i++) {
            int length=(th[i][1]-th[i][0])*2+1;
            int m=th[i][0]-1;
            int l=th[i][0]-1;
            long[] d=new long[length+1];
            for (int j = 0; j <=length ; j++) {
                if (m > th[i][1] - 1 || l < th[i][1] && b[l] <= a[m]) {
                    d[j]=b[l++];
                }
                else {
                    d[j]=a[m++];
                }
            }
//            while (m>=th[i][0]-1&&l>=th[i][0]-1){
//                if(a[m]<b[l]){
//                    d[length--]=b[l--];
//                }
//                else {
//                    d[length--]=a[m--];
//                }
//            }
//            while (l>=th[i][0]-1){
//                d[length--]=b[l--];
//            }
//            while (m>=th[i][0]-1){
//                d[length--]=a[m--];
//            }
                System.out.println(d[((th[i][1]-th[i][0])*2+1)/2]);

        }


    }
}
