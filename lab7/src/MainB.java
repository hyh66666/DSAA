import java.io.*;
import java.util.StringTokenizer;

public class MainB {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        node[] node=new node[n];
        for (int i = 0; i < n; i++) {
            node[i]= new node(i + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            node[u-1].count++;
            node[v-1].count++;
        }
        for (int i = 0; i < n; i++) {
            if(node[i].count==1){
                out.print(node[i].number+" ");
                out.flush();
            }
        }



    }
    static class node {
        int number;
        int count=0;
        public node(int a){
            number=a;
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
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}

