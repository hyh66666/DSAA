import java.io.*;
import java.util.StringTokenizer;

public class MainD1 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n =in.nextInt();
        long[]A=new long[n];
        for (int i = 0; i < n; i++) {
            A[i]=in.nextInt();
        }
        long result=result(A);
        out.println(result);
        out.flush();

    }
    static class node{
        long value;
        node left;
        node right;
        boolean isVisit=false;
        public node(long a) {
            this.value=a;
        }

    }
    public static long result(long[] array){
        int n=array.length;
        int m=2*n-1;
        long res=0;
        node[] tree=new node[m];
        for (int i = 0; i < n; i++) {
            tree[i]=new node(array[i]);
        }
        for (int i = n; i < m; i++) {
            node min1=select(tree,i-1);
            min1.isVisit=true;
            node min2=select(tree,i-1);
            min2.isVisit=true;
            tree[i]=new node(min1.value+min2.value);
            tree[i].left=min1;
            tree[i].right=min2;
        }
        for (int i = n; i < m; i++) {
            res+=tree[i].value;
        }
        return res;
    }
    public static node select(node[] nodes, int end){
        node min=new node(10000000);
        for (int i = 0; i <= end; i++) {
            node temp=nodes[i];
            if(!temp.isVisit&&temp.value< min.value){
                min=temp;
            }
        }
        return min;

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
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}
