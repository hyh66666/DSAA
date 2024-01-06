import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainF1 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int T=in.nextInt();
        for (int i = 0; i < T; i++) {
            int n=in.nextInt();
            int k=in.nextInt();
            node[] nodes=new node[n];
            for (int j = 0; j < n; j++) {
                nodes[j]=new node(j+1);
            }
            for (int j = 0; j < n-1; j++) {
                int cityA=in.nextInt();
                int cityB=in.nextInt();
                nodes[cityA-1].edges.add(nodes[cityB-1]);
                nodes[cityB-1].edges.add(nodes[cityA-1]);
            }
            int [] people=new int[k];
            for (int j = 0; j < k; j++) {
                people[j]=in.nextInt();
            }
            int[] dis=new int[n];
            int max=0;
            int temp=0;
            distance(dis,nodes,people[0],n);
//            for (int j = 0; j < n; j++) {
//                out.print(dis[j]+" ");
//            }
//            out.println();
//            out.flush();
            for (int j = 0; j <k ; j++) {
                if(dis[people[j]-1]>max||dis[people[j]-1]==max){
                    max=dis[people[j]-1];
                    temp=people[j];
                }
            }
//            out.println(temp);
//            out.flush();
            for (int j = 0; j < n; j++) {
                nodes[j].isvisited=false;
            }
            distance(dis,nodes,temp,n);
//            for (int j = 0; j < n; j++) {
//                out.print(dis[j]+" ");
//            }
//            out.println();
//            out.flush();
            max=0;
            for (int j = 0; j <k ; j++) {
                if(dis[people[j]-1]>max||dis[people[j]-1]==max){
                    max=dis[people[j]-1];
                }
            }
            if(max%2==0){
                out.println(max/2);
            }
            else {
                out.println(max/2+1);
            }
            out.flush();
        }
    }
    public static void distance(int [] dis,node[] nodes,int people,int n){
        node[] queue=new node[n];
        int front =0;int rear=0;
        queue[rear++]=nodes[people-1];
        nodes[people-1].isvisited=true;
        int deepth=0;
        dis[people-1]=deepth;
        deepth++;
        int popcount=0,count=0,size=1;
        while (front<rear){
            node temp=queue[front];
            if(front==0){
                count+=temp.edges.size();
            }
            else {
                count += temp.edges.size() - 1;
            }

            for (int j = 0; j < temp.edges.size(); j++) {
                if(!temp.edges.get(j).isvisited){
                    dis[temp.edges.get(j).index-1]=deepth;
                    queue[rear++]=temp.edges.get(j);
                    temp.edges.get(j).isvisited=true;
                }

            }
            front++;
            popcount++;
            if(popcount==size){
                deepth++;
                popcount=0;
                size=count;
                count=0;

            }
        }
    }
    static class node{
        boolean isvisited;
        int index;
        public node(int index){
            this.index=index;
        }
        ArrayList<node> edges=new ArrayList<>();
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
