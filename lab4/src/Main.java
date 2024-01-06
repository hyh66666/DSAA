import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        fastReader in = new fastReader();
        int n=in.nextInt();
        int m=in.nextInt();
        long count=0;
        node head= new node(-2000000000, 2000000000);
        node cur=head;
        for (int i = 0; i < n; i++) {
            node a= new node(in.nextInt(), in.nextInt());
            cur.next=a;
            cur=cur.next;
            count++;
        }
        cur=head;
        for (int i = 0; i < m; i++) {
            node b=new node(in.nextInt(),in.nextInt());
            if(b.coe!=0){
                if(cur.next!=null) {
                    if (b.exp > cur.next.exp) {
                        b.next = cur.next;
                        cur.next = b;
                        count++;
                        cur = cur.next;
                        continue;
                    }
                    if (b.exp == cur.next.exp) {
                        cur.next.coe = cur.next.coe + b.coe;
                        cur = cur.next;
                        continue;
                    }
                }
                while (cur.next != null && b.exp < cur.next.exp) {
                    cur = cur.next;
                }
                if (cur.next == null) {
                    cur.next = b;
                    count++;
                } else {
                    if (b.exp > cur.next.exp) {
                        b .next= cur.next;
                        cur.next = b;
                        count++;

                    } else {
                        cur.next.coe = cur.next.coe + b.coe;
                    }
                }
                cur=cur.next;
            }
        }
        out.println(count);
        cur=head;
        for (int i = 0; i < count; i++) {
            if(cur.next.coe!=0) {
               out.print(cur.next.coe+" "+cur.next.exp);
               out.println();
            }
            cur=cur.next;
        }
        out.flush();

    }
    static class node{
        int coe;
        int exp;
        node next;
    public node(int coe,int exp) {
        this.coe=coe;
        this.exp=exp;
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
