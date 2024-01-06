import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in= new Scanner( System.in);
        Node head=new Node(5);
        head.next=head;
        System.out.println(head.data);
        System.out.println(head.next.data);

    }
    static class Node{
        int data;
        Node next;
        Node pre;
        public Node(int data){
            this.data=data;
        }
    }
}
