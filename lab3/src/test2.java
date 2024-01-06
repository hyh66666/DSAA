import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int []A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=in.nextInt();
        }
        int b,k;
        for (int i = 0; i < A.length-1; i++) {
            k=i;
            for (int j = i+1; j <A.length ; j++) {
                if(A[i]>A[j]){
                    k=j;
                    b=A[i];
                    A[i]=A[k];
                    A[k]=b;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]+" ");
        }
    }


    }

