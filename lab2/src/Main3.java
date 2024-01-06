import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] b = new int[a];
        int f = 0;
        for (int i = 0; i < a; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < a-1; i++) {
            for (int j = i + 1; j < a; j++) {
                long c = b[i] + b[j];
                if(is(c)){
                    f++;
                }
            }
        }
        System.out.println(f);
    }
    public static boolean is(long c){
       return c>0&&(c&(c-1))==0;
    }
    }


