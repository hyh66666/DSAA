import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainE {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        node[] nodes=new node[n];
        for (int i = 0; i < n; i++) {
            nodes[i]=new node(i+1);
        }
        int k=n;
        for (int i = 0; i < m; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            if(w==2){
                node temp=new node(++k);
                nodes[u-1].edges.add(temp);
                temp.edges.add(nodes[v-1]);
            }
            else {
                nodes[u-1].edges.add(nodes[v-1]);
            }
        }
        int result;
        result=bfs(nodes[0],n );
        if(result==0){
            out.println(-1);
        }
        else {
            out.println(result);
        }
        out.close();


    }
    public static int bfs(node root, int end){
        Queue<node> queue= new LinkedList<>();
        queue.add(root);
        root.isVisited++;
        while (queue.size()!=0){
            node temp=queue.peek();
            queue.poll();
            if(temp.index==end){
                return temp.step;
            }
            for (int i = 0; i < temp.edges.size(); i++) {
                if(temp.edges.get(i).isVisited<1){
                    temp.edges.get(i).step=temp.step+1;
                    queue.add(temp.edges.get(i));
                    temp.edges.get(i).isVisited++;
                }
            }


        }


        return  0;


    }
    public static void dfs(node root,ArrayList<String> arrayList, int target,  String s){
        int temp=0;
        if(root==null){
            return ;
        }
        else if(root.index==target){
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)==' '){
                    arrayList.add(s.substring(temp,i));
                    temp=i;
                }
                if(i==s.length()-1){
                    arrayList.add(s.substring(temp,s.length()));
                }
            }
        }
        else {
            for (int i = 0; i < root.edges.size(); i++) {
                if(root.edges.get(i).isVisited<1){
                    root.edges.get(i).isVisited++;
                    dfs(root.edges.get(i),arrayList,target,s+" "+root.edges.get(i).index);
                }
            }
        }
    }
    static class node{
        int index;
        int isVisited=0;
        int step=0;
        public node(int index){
            this.index=index;
        }
        ArrayList<node> edges=new ArrayList<>();
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
