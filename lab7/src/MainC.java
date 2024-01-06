import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner in=new Scanner( System.in);
        int T=in.nextInt();
        int h=70;
        for (int i = 0; i < T; i++) {
            long num=in.nextLong();
            for (int j = 0; j < h; j++) {
                if(num<=Math.pow(2,j+1)-1&&num>Math.pow(2,j)-1){
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
