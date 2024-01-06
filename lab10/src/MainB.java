import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainB {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] U = new int[m];
        int[] V = new int[m];
        int min = -1;
        for (int i = 0; i < m; i++) {
            U[i] = in.nextInt();
            V[i] = in.nextInt();
        }
        int left = -1, right = m;
        if(m>=n){
        while (right>left+1) {
            int mid = left + (right - left) / 2;
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
                nodes[i].idx = i + 1;
            }
            for (int i = 0; i < mid; i++) {
                int u = U[i];
                int v = V[i];
                nodes[u - 1].children.add(nodes[v - 1]);
                nodes[v - 1].reverse.add(nodes[u - 1]);
            }
            if (dfs(nodes[0]) == n) {
                for (int j = 0; j < n; j++) {
                    nodes[j].isVisit = false;
                }
                if (rvDfs(nodes[0]) == n) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                left = mid ;
            }
        }
    }


        Node[] nodes=new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i]=new Node();
            nodes[i].idx=i+1;
        }
        for (int i = 0; i < right; i++) {
            int u = U[i];
            int v = V[i];
            nodes[u - 1].children.add(nodes[v - 1]);
            nodes[v - 1].reverse.add(nodes[u - 1]);
        }
        if(dfs(nodes[0])==n){
            for (int j = 0; j < n; j++) {
                nodes[j].isVisit = false;
            }
            if(rvDfs(nodes[0])==n){
                min=right;
            }
        }
        out.println(min);
        out.close();


    }
    public static int rvDfs(Node node){
        int result=0;
        node.isVisit=true;
        result++;
        for (int i = 0; i < node.reverse.size(); i++) {
            if(!node.reverse.get(i).isVisit){
                result+=rvDfs(node.reverse.get(i));
            }
        }

        return result;
    }
    public static int dfs(Node node){
        int result=0;
        node.isVisit=true;
        result++;
        for (int i = 0; i < node.children.size(); i++) {
            if(!node.children.get(i).isVisit){
                result+=dfs(node.children.get(i));
            }
        }

        return result;
    }
    static  class Node{
        boolean isVisit=false;
        int idx;
        ArrayList<Node> children=new ArrayList<>();
        ArrayList<Node> reverse= new ArrayList<>();

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
