import java.util.ArrayList;
import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int count=s.length()*(s.length()+1)/2;
        ArrayList<String> stringList=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0,l=i+1; l <=s.length() ; j++,l++) {
                if(stringList.contains(s.substring(j,l))){
                    count--;
                    continue;
                }
                else {
                    stringList.add(s.substring(j,l));
                }
            }
        }
        System.out.println(count);
    }
}
