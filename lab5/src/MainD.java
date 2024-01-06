import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String brackets=in.next();
        int top=-1;
        int result=0;
        Stack[] stack=new Stack[brackets.length()];
        for (int i = 0; i < stack.length; i++) {
            stack[++top]=new Stack(brackets.charAt(i));
            if(top>0){
                if(stack[top].bracket==')'&&stack[top-1].bracket=='(') {
                    top -= 2;
                    if (top == -1) {
                        if (stack[top + 1].content != 0) {
                            result+=stack[top+1].content*2%514329;
                            stack[top + 1].content= 0;
                        } else {
                            result =(result+ 1)%514329;
                        }
                    }
                    else {
                        if (stack[top + 1].content == 0) {
                            stack[top].content=(stack[top].content+1)%514329;
                        } else {
                            stack[top].content += stack[top + 1].content * 2%514329;
                            stack[top + 1].content = 0;
                        }
                    }
                }
            }

        }
        if(top==-1){
            System.out.print(result);
        }


    }
    static class Stack{
        int content=0;
        char bracket;
        public Stack(char bracket){
            this.bracket=bracket;
        }
    }
}
