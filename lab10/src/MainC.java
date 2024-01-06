import java.io.*;
import java.util.*;
class node{
    int number;
    LinkedList<node_w> edge = new LinkedList<node_w>();
    public node (int number){
        this.number = number;
    }
}
class node_w{
    node node;
    int weight;
    public node_w (node node,int weight){
        this.node=node;
        this.weight = weight;
    }
}
class MainC {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        long number = 0;
        HashMap<node, Integer> hm = new HashMap<node, Integer>();
        PriorityQueue<node_w> pq = new PriorityQueue<>(n, Comparator.comparingInt(i -> i.weight));
        node[] array = new node[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = new node(i);
            hm.put(array[i],i);
        }
        int min = Integer.MAX_VALUE;
        int u=0,v=0;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (c<min){
                min = c;
                u = a;
                v = b;
            }
            array[a].edge.add(new node_w(array[b], c));
            array[b].edge.add(new node_w(array[a], c));
        }
        number+=min;
        hm.remove(array[u]);
        hm.remove(array[v]);
        for (node_w a:array[u].edge) {
            if (hm.containsKey(a.node)) {
                pq.add(a);
            }
        }
        for (node_w a:array[v].edge) {
            if (hm.containsKey(a.node)) {
                pq.add(a);
            }
        }
        node_w tmp;
        while (!hm.isEmpty()){
            while (true) {
                tmp = pq.poll();
                if (hm.containsKey(tmp.node)){
                    break;
                }
            }
            number+=tmp.weight;
            hm.remove(tmp.node);
            for (node_w a:tmp.node.edge) {
                if (hm.containsKey(a.node)) {
                    pq.add(a);
                }
            }
        }
        out.println(number);
        out.close();
    }
}

class QReader {
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

class QWriter implements Closeable {
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
    }
}