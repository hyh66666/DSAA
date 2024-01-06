import java.util.Scanner;

public class MainF {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int k=in.nextInt();
        int n=in.nextInt();
        int count=1;
        int result=1;
        long min = 0,max = 0;
        boolean flag=true;
        Queue queue=new Queue();
        for (int i = 0; i < n; i++) {
            queue.enQueue(in.nextInt());
        }
        while (queue.front< queue.rear){
            queue.temp++;
            if(queue.temp== queue.rear){
                if(result<count){
                    result=count;
                }
                queue.dequeue();
                if(queue.rear-queue.front<=result) {
                    break;
                }
                count=1;
                flag=true;
                continue;
            }
            if(flag) {
                if (queue.sequence[queue.front] < queue.sequence[queue.temp]) {
                    min = queue.sequence[queue.front];
                    max = queue.sequence[queue.temp];
                } else {
                    max = queue.sequence[queue.front];
                    min = queue.sequence[queue.temp];
                }
                flag=false;
            }
            else {
                if(min>queue.sequence[queue.temp]){
                    min=queue.sequence[queue.temp];
                }
                else if(max<queue.sequence[queue.temp]){
                    max=queue.sequence[queue.temp];
                }
                else if(min<=queue.sequence[queue.temp]&&queue.sequence[queue.temp]<=max){
                    count++;
                    continue;
                }
            }
            if(max-min>k){
                if(result<count){
                    result=count;
                }
                queue.dequeue();
                if(queue.rear-queue.front<=result) {
                    break;
                }
                count=1;
                flag=true;
            }
            else {
                count++;
            }
        }
        System.out.print(result);

    }
    static class Queue{
        private int front;
        private int rear;
        private int temp;
        private final long[] sequence=new long[3000000];
        public Queue(){
            front=0;
            rear=0;
            temp=0;
        }
        public void enQueue(long content){
            sequence[rear]=content;
            rear++;
        }
        public void dequeue(){
                front++;
                temp=front;
        }

    }

}
