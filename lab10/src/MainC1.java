import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainC1 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        Node[] city=new Node[n];
        for (int i = 0; i < n; i++) {
            city[i]=new Node();
            city[i].idx=i;
        }
        for (int i = 0; i < m; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            long w=in.nextInt();
            city[u-1].nodes.add(city[v-1]);
            city[v-1].nodes.add(city[u-1]);
            city[u-1].weight.add(w);
            city[v-1].weight.add(w);
        }
        out.println(prim(city));
        out.close();

    }
    public static long prim(Node[] city){
        int index=0;
        long sum=0;
        ArrayList<Node> mst=new ArrayList<>();
        mst.add(city[0]);
        city[0].isVisit=true;
        for (int i = 1; i < city.length; i++) {
            long min=Long.MAX_VALUE;
            for (Node node : mst) {
                for (int k = 0; k < node.weight.size(); k++) {
                    if (!node.nodes.get(k).isVisit && min > node.weight.get(k)) {
                        min = node.weight.get(k);
                        index = node.nodes.get(k).idx;
                    }
                }
            }
            sum+=min;
            mst.add(city[index]);
            city[index].isVisit=true;
        }
        return sum;
    }
    static class Node{
        boolean isVisit=false;
        ArrayList<Node> nodes=new ArrayList<>();
        ArrayList<Long> weight=new ArrayList<>();
        int idx;
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
