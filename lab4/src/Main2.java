import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) {
        fastReader in =new fastReader();
        int n= in.nextInt();
        int p= in.nextInt();
        int q= in.nextInt();
        node[]node=new node[n];
        node cur = null;
        for (int i = 0; i < n; i++) {
            node[i]=new node(in.nextInt(),1);
        }
        for (int i = 0; i < p; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            if(node[a-1].length==1) {
                node[a - 1].next = node[b - 1];
                cur=node[b-1];
                node[a - 1].length++;
                node[b-1].length=0;
                continue;
            }
            if(node[a-1].length>1){
                assert cur != null;
                cur.next=node[b-1];
                cur=cur.next;
            }
        }
        for (int i = 0; i < n; i++) {
            int count=1;
            if(node[i].length>1){
                node temp=node[i];
                for (int j = 1; j < q&&temp.next!=null; j++) {
                    temp=temp.next;
                    count++;
                }
                if(count==q){
                    out.print(temp.weight+" ");
                }

            }
        }
        out.flush();

    }
    static class node{
        int weight;
        int length;
        node next;
        public node(int weight,int length){
            this.weight=weight;
            this.length=length;
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
