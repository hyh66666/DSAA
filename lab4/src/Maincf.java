import java.io.*;
import java.util.Scanner;

public class Maincf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt(),q = sc.nextInt();
            Node[] heads = new Node[n];
            Node[] tails = new Node[n];
            for (int i = 0; i < n; i++) {
                Node head = new Node(0);
                Node tail = new Node(0);
                head.next = tail;
                tail.pre = head;
                heads[i] = head;
                tails[i] = tail;
            }
            for (int i = 0; i < q; i++) {
                int type = sc.nextInt();
                int queueNum,operationType;
                switch (type){
                    case 1:
                        queueNum = sc.nextInt();
                        operationType = sc.nextInt();
                        int operationNum = sc.nextInt();
                        Node temp = new Node(operationNum);
                        if (operationType==0){
                            Node head = heads[queueNum-1];
                            temp.next = head.next;
                            head.next.pre = temp;
                            head.next = temp;
                            temp.pre = head;
                        } else {
                            Node tail = tails[queueNum-1];
                            temp.pre = tail.pre;
                            tail.pre.next = temp;
                            tail.pre = temp;
                            temp.next = tail;
                        }
                        break;
                    case 2:
                        queueNum = sc.nextInt();
                        operationType = sc.nextInt();
                        if (operationType==0){
                            Node head = heads[queueNum-1];
                            if (head.next.value!=0){
                                out.println(head.next.value);
                                head.next.next.pre = head;
                                head.next = head.next.next;
                            }
                            else {
                                out.println(-1);
                            }
                        } else {
                            Node tail = tails[queueNum-1];
                            if (tail.pre.value!=0){
                                out.println(tail.pre.value);
                                tail.pre.pre.next = tail;
                                tail.pre = tail.pre.pre;
                            } else {
                                out.println(-1);
                            }
                        }
                        break;
                    case 3:
                        queueNum = sc.nextInt();
                        int queueNum2 = sc.nextInt();
                        operationType = sc.nextInt();
                        Node cur1 = tails[queueNum-1].pre;
                        Node cur2;
                        if (operationType==0){
                            cur2 = heads[queueNum2 - 1].next;
                            while (cur2.value!=0){
                                Node cur = new Node(cur2.value);
                                cur1.next.pre = cur;
                                cur.next = cur1.next;
                                cur.pre = cur1;
                                cur1.next = cur;
                                cur2 = cur2.next;
                                cur1 = cur1.next;
                            }
                            heads[queueNum2-1].next = tails[queueNum2-1];
                            tails[queueNum2-1].pre = heads[queueNum2-1];
                        } else {
                            cur2 = tails[queueNum2 - 1].pre;
                            while (cur2.value!=0){
                                Node cur = new Node(cur2.value);
                                cur1.next.pre = cur;
                                cur.next = cur1.next;
                                cur.pre = cur1;
                                cur1.next = cur;
                                cur2 = cur2.pre;
                                cur1 = cur1.next;
                            }
                            heads[queueNum2-1].next = tails[queueNum2-1];
                            tails[queueNum2-1].pre = heads[queueNum2-1];
                        }

                        break;
                }
            }
            out.flush();
        }
    }
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
class Node{
    int value;
    Node next;
    Node pre;
    public Node(int value){
        this.value = value;
    }
}