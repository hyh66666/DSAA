import java.util.Scanner;

public class LendMoney {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("你是否想借钱给周业茗？");
        System.out.println("Yes/No");
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("Yes")) {
                System.out.println("余额不足");
                System.out.println("请重新选择");
            }
            else if (s.equals("No")) {
                System.out.println("干的漂亮");
                break;
            }
            else {
                System.out.println("没有此选项");
            }
        }
        System.out.println("程序结束");
    }
}
