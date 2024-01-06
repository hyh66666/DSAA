import java.util.Scanner;

public class a4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] strings=new String[4];
        for (int i = 0; i < strings.length; i++) {
            strings[i]=in.next();
        }
        int count=0;//记违例的次数
        int score=100;
        //判断是否符合规定，不符合时count++;
        for (String string : strings) {
            int nCount = 0;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == 'N') {
                    nCount++;
                }
                if (nCount > 2) {
                    count++;
                    break;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            score=score-10-5*i;
        }
        System.out.println(score);
    }
}