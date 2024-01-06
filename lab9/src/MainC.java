import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainC {
    private static boolean flag;
    public static void main(String[] args) {

        QReader in=new QReader();
        QWriter out=new QWriter();
        int n= in.nextInt();
        Node[] nodes=new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i]=new Node();
            nodes[i].index=i+1;
        }
        int m=in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u - 1].edges.add(nodes[v - 1]);
            nodes[v - 1].edges.add(nodes[u - 1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(nodes,i+1,0);
            if(flag){
                out.println("Bad");
                break;
            }
        }

        if(!flag){
            out.println("Good");
        }
        out.close();

    }
    public static void dfs(Node[] nodes,int cur,int parent) {
        if (!nodes[cur - 1].isVisited){
            nodes[cur - 1].isVisited = true;
        for (int i = 0; i < nodes[cur - 1].edges.size(); i++) {
            if (!nodes[cur - 1].edges.get(i).isVisited) {
                dfs(nodes, nodes[cur - 1].edges.get(i).index, cur);
            } else if (nodes[cur - 1].edges.get(i).index != parent) {
                flag = true;// has cycle
                return;


            }
        }
    }

    }
    static class Node{
        int index;
        boolean isVisited=false;
        ArrayList<Node> edges=new ArrayList<>();

    }
    static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    static class QWriter implements Closeable {
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }}
}
