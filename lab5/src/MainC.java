import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int T=in.nextInt();
        for (int i = 0; i < T; i++) {
            int n=in.nextInt();
            String stack=in.next();
            String [] brackets=new String[n];
            int count=-1;
            for (int j = 0; j < n; j++) {
                brackets[++count]= String.valueOf(stack.charAt(j));
                if(count-1>=0) {
                    if ((brackets[count - 1].equals("(") && brackets[count].equals(")")) || (brackets[count - 1].equals("[") && brackets[count].equals("]")) || (brackets[count - 1].equals("{") && brackets[count].equals("}")))
                        count -= 2;
                }
            }
            if(count==-1){
                System.out.println("YES");
            }
            if(count!=-1){
                System.out.println("NO");
            }
        }
    }
}
