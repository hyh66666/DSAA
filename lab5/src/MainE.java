import java.io.*;
import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
        int q = in.nextInt();
        int p;
        Queue[] queue = new Queue[n];
        for (int i = 0; i < n; i++) {
            queue[i] = new Queue();
        }
        for (int i = 0; i < q; i++) {
            int t = in.nextInt();
            int u = in.nextInt();
            if (t == 1) {
                int w = in.nextInt();
                int val = in.nextInt();
                if (w == 0) {
                    queue[u - 1].enfQueue(val);
                }
                if (w == 1) {
                    queue[u - 1].enrQueue(val);
                }
            }
            if (t == 2) {
                int w = in.nextInt();
                if (w == 0) {
                    p = queue[u - 1].popf();
                    out.println(p);
                    out.flush();
                }
                if (w == 1) {
                    p = queue[u - 1].popr();
                    out.println(p);
                    out.flush();
                }
            }
            if (t == 3) {
                int v = in.nextInt();
                int w = in.nextInt();
                if (w == 0) {
                    Node cur = queue[v - 1].head.next;
                    while (cur != queue[v - 1].tail) {
                        queue[u - 1].enrQueue(cur.data);
                        cur = cur.next;
                    }
                    queue[v - 1].head.next = queue[v - 1].tail;
                    queue[v - 1].tail.pre = queue[v - 1].head;
                }
                if (w == 1) {
                    Node cur = queue[v - 1].tail.pre;
                    while (cur != queue[v - 1].head) {
                        queue[u - 1].enrQueue(cur.data);
                        cur = cur.pre;
                    }
                    queue[v - 1].head.next = queue[v - 1].tail;
                    queue[v - 1].tail.pre = queue[v - 1].head;
                }
            }

        }
    }

    }
    static class Node{
        int data;
        Node next;
        Node pre;
        public Node(int data){
            this.data=data;
        }
    }

    static class Queue {
        Node head=new Node(0);
        Node tail=new Node(0);
        public Queue() {
            head.next=tail;
            tail.pre=head;
        }

        public void enrQueue(int content) {
            Node a=new Node(content);
            a.pre=tail.pre;
            tail.pre.next=a;
            tail.pre=a;
            a.next=tail;
        }
        public void enfQueue(int content){
            Node a=new Node(content);
            head.next.pre=a;
            a.next=head.next;
            head.next=a;
            a.pre=head;
        }
        public int popf(){
            int b;
            if(tail.pre==head){
                b=-1;
            }
            else {
                b=head.next.data;
                head.next.next.pre=head;
                head.next=head.next.next;
            }
            return b;
        }
        public int popr(){
            int b;
            if(tail.pre==head){
                b=-1;
            }
            else {
                b=tail.pre.data;
                tail.pre.pre.next=tail;
                tail.pre=tail.pre.pre;

            }
            return b;
        }

    }
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}

