import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int T=in.nextInt();
        String[] events=new String[T];
        Queue queue=new Queue();
        Stack stack=new Stack();
        for (int i = 0; i < T; i++) {
            events[i]=in.next();
            if(events[i].equals("NewComer")){
                queue.enQueue(in.next());
            }
            if(events[i].equals("NewFood")){
                stack.push(in.next());
            }
            if(events[i].equals("TakeFood")){
                boolean a=Takefood(queue,stack);
            }
        }
        int count = 0;
        boolean isTake;
            while (queue.front<queue.rear){
                isTake=Takefood(queue,stack);
                if(isTake) {
                    count = 0;
                }
                else {
                    count++;
                }
                if(count== queue.size||stack.size==0){
                    break;
                }
            }

        if(count==0){
            System.out.print("Qi Fei!");
        }
        else {
            System.out.print(count);
        }


    }
    public static boolean Takefood(Queue queue,Stack stack){
        String temp;
        boolean flag=false;
        if(stack.size!=0&&queue.size!=0){
            if(queue.people[queue.front].equals(stack.food[stack.top])) {
                temp=queue.dequeue();
                stack.pop();
                flag=true;
            }
            else {
                temp= queue.dequeue();
                queue.enQueue(temp);
            }
        }
        return flag;
    }
    static class Queue{
     private int front;
     private int rear;
     private final String[] people=new String[100000];
     private int size;
     public Queue(){
         front=0;
         rear=0;
         size=0;
     }
     public void enQueue(String event){
             people[rear]=event;
             rear++;
             size++;
     }
     public String dequeue(){
         String temp="";
         if(front<rear){
             temp=people[front];
             front++;
             size--;
         }
         else {
             System.out.println("Queue is empty, no deQueue");
         }
         return temp;
     }

    }

    static class Stack{
        private int top;
        private int size;
        private final String[] food=new String[100000];
        public Stack(){
            top=-1;
            size=0;
        }
        public void push(String event){
            food[++top]=event;
            size++;
        }
        public void pop(){
            if(top==-1){
                System.out.println("Stack is EMPTY! No pop!");
            }
            else {
                top--;
                size--;
            }
        }
    }
}
