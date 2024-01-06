import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < a; i++) {
            long sum,n=b[i];
            sum=(n*(n+1)/2+n*(n+1)*(2*n+1)/6)/2;
            System.out.println(sum);
        }
        }

}


