import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,h;
        long max=0,max1=0;
        n=in.nextInt();
        h=in.nextInt();
        int min=h,min1=h;
        int[]A=new int[n-1];
        int[]B=new int[n-1];
        for (int i = 0; i < n-1; i++) {
            A[i]=in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            B[i]=in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
            if(B[i]>max1){
                max1=B[i];
            }
            if(B[i]<min1){
                min1=B[i];
            }
        }
        long Sa=0,Sb=0;
        for (int i = 0; i < n-1; i++) {
            Sa=Sa+A[i];
            Sb=Sb+B[i];
        }
        long []result=new long[9];

        if(Sa-max>Sb-max1){
            result[0]=1-min1;
        }
        if (Sa-max>Sb-min1){
             result[8]=1-h;
        }
        long i = Sa - Sb + min1 + max1 - max;

        if(i >min1+1&& i <max1){
            result[1]=2- i;
        }
        if(i>=max1){
            result[1]=2-max1;
        }
        long j=Sb-max1-Sa+max+min;
        if(j<=min){
            result[2]=min+1-min1;
        }
        if(j>min&&j<max-1){
            result[2]=j+1-min1;
        }
        long k=Sb-Sa-max1+max-min1+min;

        if (k<=min-max1){
            result[3]=min-max1+1;
        }
        if(min-max1<k&&k<max-min1-1){
            result[3]=k+1;
        }
        long l=Sb-Sa-min1+max+min;
        if(l<=min){
            result[4]=min+1-h;
        }
        if(l>min&&l<max-1){
            result[4]=l+1-h;
        }
        if(Sa-min>Sb-max1){
            result[5]=max-min1;
        }
        long m=Sa-min-Sb+max1+min1;
        if(m>=max1){
            result[6]=max-max1+1;
        }
        if(m>min1+1&&m<max1){
            result[6]=max-m+1;
        }
        if(Sa-min>Sb-min){
           result[7]=max-h;
        }
        int v=0;
        long z=h;
        for (int o = 0; o < 9; o++) {
            if(result[o]==0){
                v=v+1;
            }
            if(result[o]!=0&&result[o]<=z){
                z=result[o];
            }
        }
        if(v==9){
            System.out.println("IMPOSSIBLE");
        }
        if(v!=9){
            System.out.println(z);
        }
    }

}
