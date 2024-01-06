import java.io.*;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        int m=in.nextInt();
        node head=new node(0);
        node cur=head;
        for (int i = 1; i <= n; i++) {
            node a=new node(i);
            cur.next=a;
            cur=cur.next;
        }
        cur=head;
        int count=n;
            for (int i = 1; ; i+=m) {
                if(i>n){
                    i=1;
                    n=count;
                    cur=head;
                }
                int temp=0;
                if(cur.next==null){
                    continue;
                }
                    out.print(cur.next.order+" ");
                    cur.next = cur.next.next;
                    count--;
                    if(count==m){
                        break;
                    }

                while (temp<m-1&&cur.next!=null) {
                    cur = cur.next;
                    temp++;
                }
            }
        cur=head;
        for (int j = 0; j < count; j++) {
            out.print(cur.next.order+" ");
            cur=cur.next;
        }
            out.flush();


    }
    static class node{
        int order;
        node next;
        public node(int order) {
            this.order=order;
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
