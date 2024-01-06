import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int b=in.nextInt();
        double[]a=new double[b];
        for (int i = 0; i < b; i++) {
            a[i]=in.nextInt();
        }
        for (int i = 0; i < b; i++) {
            double left=0,right=400;
            while (left<=right){
                double mid=left+(right-left)/2;
                double e=2.718281828459;
                double v = mid * Math.pow(e, mid/20) - a[i];
                if(v <0.01&& v >-0.01){
                    System.out.println(mid);
                    break;
                }
                if(v<-0.01||v==-0.01){
                    left=mid;
                }
                else {
                    right=mid;
                }
            }
        }
    }
}
