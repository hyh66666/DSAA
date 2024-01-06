import java.io.*;
import java.util.StringTokenizer;

public class MainC2 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int [][] graph=new int[n][n];
        int[] dis=new int[n];
        boolean[] isVisit=new boolean[n];
        for (int i = 0; i < m; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            graph[u-1][v-1]=w;
            graph[v-1][u-1]=w;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j]==0){
                    graph[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        out.println(prim(graph,dis,isVisit));
        out.close();
    }
    public static long prim(int [][] graph,int [] dis,boolean[] isVisit){
        int idx=0;
        long sum=0;
        isVisit[0]=true;
        System.arraycopy(graph[0], 0, dis, 0, graph.length);
        for (int i = 1; i < graph.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < graph.length; j++) {
                if(!isVisit[j]&&dis[j]<min){
                    min=dis[j];
                    idx=j;
                }
            }
            isVisit[idx]=true;
            sum+=min;
            for (int j = 0; j < graph.length; j++) {
                if(!isVisit[j]&&dis[j]>graph[idx][j]){
                    dis[j]=graph[idx][j];
                }
            }
        }
        return sum;

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
