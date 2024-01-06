import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainF {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int t=in.nextInt();
        for (int i = 0; i < t; i++) {
            int n=in.nextInt();
            int m=in.nextInt();
            Node[]nodes=new Node[n];
            for (int j = 0; j < n; j++) {
                nodes[j]=new Node();
            }
            for (int j = 0; j < n; j++) {
                nodes[j].a=in.nextInt();
                nodes[j].b=in.nextInt();
            }

            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u - 1].kids.add(nodes[v - 1]);
                nodes[v - 1].inDegree++;
                nodes[v - 1].index = v;
                nodes[u - 1].index = u;
            }
            long result = 0;
            long mod= (long) Math.pow(10,9)+7;
            for (int j = 0; j < nodes.length; j++) {
                if(nodes[j].inDegree==0&&!nodes[j].isVisited){
                    result=  (result%mod+sum(nodes,j)%mod)%mod;
                }
            }
            out.println(result);

        }
        out.close();
    }
    public static long sum(Node[]nodes,int cur){
        long result = 0;
        long mod= (long) Math.pow(10,9)+7;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(nodes[cur]);
        nodes[cur].isVisited=true;
        while (queue.size()!=0){
            Node temp=queue.poll();
            for (int i = 0; i < temp.kids.size(); i++) {
                temp.kids.get(i).inDegree--;
                temp.kids.get(i).isVisited=true;
                result = (result%mod + ((temp.a%mod) * (temp.kids.get(i).b % mod))%mod) % mod;
                temp.kids.get(i).a = (temp.kids.get(i).a%mod + temp.a % mod) % mod;
                if(temp.kids.get(i).inDegree==0){
                    queue.offer(temp.kids.get(i));
                }
            }
        }



        return result;
    }
    static class Node{
        int index;
        int inDegree=0;
        long a,b;
        boolean isVisited=false;
        ArrayList<Node> kids=new ArrayList<>();
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
