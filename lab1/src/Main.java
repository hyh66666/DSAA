import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a=in.nextInt();
        int[] arr=new int[a];
        for (int i = 0; i < a; i++) {
            arr[i]=in.nextInt();
        }
        for (int i = 0; i < a; i++) {
            int t,c,b,d;//t是位数，c是位数第几大,b是余数，d是整数
            for (int j = 0; j < Math.pow(10,9); j++) {
                if(3*(Math.pow(3,j)-1)/2<arr[i]&&arr[i]<=3*(Math.pow(3,j+1)-1)/2){

                   t=j+1;
                   c= (int) (arr[i]-3*(Math.pow(3,j)-1)/2-1);
                   StringBuilder result=new StringBuilder(0);
                    do {
                        b = c % 3;
                        d = c / 3;
                        c = d;
                        result.append(b);
                    } while (d != 0);
                   if(result.length()<t){
                       int g=result.length();
                       for (int k = 0; k < t-g;k++) {
                           result.append(0);
                       }
                   }
                   StringBuilder result1=new StringBuilder(0);
                    for (int k = 1; k <= result.length(); k++) {
                        result1.append(result,result.length()-k,result.length()-k+1);
                    }
                    StringBuilder answer= new StringBuilder(0);
                    for (int k = 0; k < result1.length(); k++) {
                        if(result1.substring(k,k+1).equals("0")){
                            answer.append("2");
                        }
                        if(result1.substring(k,k+1).equals("1")){
                            answer.append("3");
                        }
                        if(result1.substring(k,k+1).equals("2")){
                            answer.append("6");
                        }
                    }
                    System.out.println(answer);
                    break;
                }
            }
        }
    }
}
