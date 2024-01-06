import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        long num=in.nextLong();
        node[] nodes=new node[n];
        for (int i = 0; i < n; i++) {
            nodes[i]= new node();
        }
        for (int i = 0; i < n - 1; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            nodes[u-1].edges.add(nodes[v-1]);
            nodes[u-1].weights.add(w);
            nodes[v-1].edges.add(nodes[u-1]);
            nodes[v-1].weights.add(w);
        }
        node[] queue=new node[n];
        int front =0;int rear=0;
        int count=0;
        queue[rear++]=nodes[0];
        nodes[0].isvisited=true;
        while (front<rear){
            node temp=queue[front++];
            if(temp.weight==num&&temp.edges.size()==1){
                count++;
            }

                for (int i = 0; i < temp.edges.size(); i++) {
                    if(!temp.edges.get(i).isvisited){
                        temp.edges.get(i).weight=temp.weights.get(i)+temp.weight;
                        queue[rear++]=temp.edges.get(i);
                        temp.edges.get(i).isvisited=true;
                    }
                }

        }
        out.println(count);
        out.flush();

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
    static class node{
        boolean isvisited=false;
        long weight=0;
        ArrayList<node> edges=new ArrayList<>();
        ArrayList<Integer>weights=new ArrayList<>();
    }
}


