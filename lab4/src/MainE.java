import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainE {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int T=in.nextInt();
        int n;
        for (int i = 0; i < T; i++) {
            Node head=new Node(0);
            Node tail=new Node(10000000);
            Node cur=head;
            n=in.nextInt();
            for (int j = 0; j < n; j++) {
                Node a=new Node(in.nextInt());
                cur.next=a;
                a.pre=cur;
                cur=cur.next;
            }
            cur.next=tail;
            tail.pre=cur;
            ArrayList<Node> arr1=new ArrayList<>();
            cur=head;
            while (cur.next!=null){
                if (cur.next.data < cur.data) {
                    if(cur.next.next==null){
                        cur.pre.next=null;
                        break;
                    }
                    cur.next.flag = true;
                    cur.pre.next = cur.next;
                    cur.next.pre = cur.pre;
                }
                else {
                    if (cur.flag) {
                        if(cur.pre!=head) {
                            arr1.add(cur.pre);
                        }
                        cur.pre.next = cur.next;
                        cur.next.pre = cur.pre;
                    }
                }
                cur=cur.next;
            }
            while (arr1.size()>0){
                boolean flag=false;
                Node temp=new Node(1000000);
                arr1.add(temp);
                ArrayList<Node> arr2=new ArrayList<>();
                for (int j = 0; j < arr1.size()-1; j++) {
                    if(arr1.get(j).next.data<arr1.get(j).data){
                        if(arr1.get(j).next==arr1.get(j+1)){
                            arr2.add(arr1.get(j).pre);
                            arr1.get(j).pre.next=arr1.get(j).next;
                            arr1.get(j).next.pre=arr1.get(j).pre;
                            flag=true;
                        }
                        else {
                            arr1.get(j).pre.next=arr1.get(j).next.next;
                            arr1.get(j).next.next.pre=arr1.get(j).pre;
                            if(!flag){
                                arr2.add(arr1.get(j).pre);
                            }
                            flag=false;
                        }
                    }
                    else {
                        if(flag){
                            arr1.get(j).pre.next=arr1.get(j).next;
                            arr1.get(j).next.pre=arr1.get(j).pre;
                            flag=false;
                        }
                    }
                }
                arr1=arr2;
            }
            cur=head.next;
            while (cur!=tail){
                out.print(cur.data + " ");
                cur = cur.next;
            }
            out.print("\n");
            out.flush();

        }
    }
    static class Node{
        int data;
        boolean flag=false;
        Node next;
        Node pre;
        public Node(int data){
            this.data=data;
        }
    }
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static class fastReader {
        BufferedReader br;
        StringTokenizer st;
        public fastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nexLong(){return Long.parseLong(next());}
    }
}
