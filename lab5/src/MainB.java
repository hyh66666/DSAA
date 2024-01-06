import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
//        int front=0,rear=0;
        int n,p,q;
        n=in.nextInt();
        p=in.nextInt();
        q=in.nextInt();
        Queue[]queue=new Queue[n];
        int []A=new int[p];
        int[]B=new int [q];
        for (int i = 0; i < n; i++) {
            queue[i]=new Queue(i+1,0);
        }
        for (int i = 0; i < p; i++) {
            A[i]=in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            B[i]=in.nextInt();
        }
        int count=0,x=0,y=0;
        while (x<p&&y<q){
            count++;
            if (queue[A[x] - 1].member != 0&&queue[B[y] - 1].member != 0) {
                if(queue[A[x] - 1].member==queue[B[y] - 1].member){
                    queue[A[x] - 1].member = 0;
                    queue[A[x] - 1].count = count;
                    x++;
                    y++;
                }
                else {
                    queue[A[x] - 1].member = 0;
                    queue[A[x] - 1].count = count;
                    queue[B[y] - 1].member = 0;
                    queue[B[y] - 1].count = count;
                    x++;
                    y++;
                }
                }
            else if (queue[A[x] - 1].member != 0&&queue[B[y] - 1].member == 0) {
                    while (y< q && queue[B[y] - 1].member == 0) {
                        y++;
                    }
                    if(y<q) {
                        if(queue[A[x] - 1].member==queue[B[y] - 1].member){
                            queue[A[x] - 1].member = 0;
                            queue[A[x] - 1].count = count;
                            x++;
                            y++;
                        }
                        else {
                            queue[A[x] - 1].member = 0;
                            queue[A[x] - 1].count = count;
                            queue[B[y] - 1].member = 0;
                            queue[B[y] - 1].count = count;
                            x++;
                            y++;
                        }
                    }
                    else {
                        queue[A[x] - 1].member = 0;
                        queue[A[x] - 1].count = count;
                        x++;
                    }
                }
            else if(queue[A[x] - 1].member == 0&&queue[B[y] - 1].member != 0){
                while (x< p && queue[A[x] - 1].member == 0) {
                    x++;
                }
                if(x<p) {
                    if(queue[A[x] - 1].member==queue[B[y] - 1].member){
                        queue[A[x] - 1].member = 0;
                        queue[A[x] - 1].count = count;
                        x++;
                        y++;
                    }
                    else {
                        queue[A[x] - 1].member = 0;
                        queue[A[x] - 1].count = count;
                        queue[B[y] - 1].member = 0;
                        queue[B[y] - 1].count = count;
                        x++;
                        y++;
                    }
                }
                else {
                    queue[B[y] - 1].member = 0;
                    queue[B[y] - 1].count = count;
                    y++;
                }
            }
            else if(queue[A[x] - 1].member == 0&&queue[B[y] - 1].member == 0){
                while (x< p && queue[A[x] - 1].member == 0) {
                    x++;
                }
                while (y< q && queue[B[y] - 1].member == 0) {
                    y++;
                }
                if(x<p&&y<q) {
                    if(queue[A[x] - 1].member==queue[B[y] - 1].member){
                        queue[A[x] - 1].member = 0;
                        queue[A[x] - 1].count = count;
                        x++;
                        y++;
                    }
                    else {
                        queue[A[x] - 1].member = 0;
                        queue[A[x] - 1].count = count;
                        queue[B[y] - 1].member = 0;
                        queue[B[y] - 1].count = count;
                        x++;
                        y++;
                    }
                }
                else if(x==p&&y<q){
                    queue[B[y] - 1].member = 0;
                    queue[B[y] - 1].count = count;
                    y++;
                }
                else if(x<p&&y==q){
                    queue[A[x] - 1].member = 0;
                    queue[A[x] - 1].count = count;
                    x++;
                }
            }
        }
        while (x<p){
            count++;
            if (queue[A[x] - 1].member != 0) {
                queue[A[x] - 1].member = 0;
                queue[A[x] - 1].count = count;
                x++;
            }
            else if (queue[A[x] - 1].member == 0) {
                while (x < p && queue[A[x] - 1].member == 0) {
                    x++;
                }
                if(x<p) {
                    queue[A[x] - 1].member = 0;
                    queue[A[x] - 1].count = count;
                    x++;
                }
            }

        }
        while (y<q){
            count++;
            if ( queue[B[y] - 1].member != 0) {
                queue[B[y] - 1].member = 0;
                queue[B[y] - 1].count = count;
                y++;
            }
            else if (queue[B[y] - 1].member == 0) {
                while (y < q && queue[B[y] - 1].member == 0) {
                    y++;
                }
                if(y<q) {
                    queue[B[y] - 1].member = 0;
                    queue[B[y] - 1].count = count;
                    y++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(queue[i].count+" ");
        }

    }
    static class Queue {
        int member;
        int count;

        public Queue(int member, int count) {
            this.member = member;
            this.count = count;
        }
    }
}
