import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainE {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        int count=1;
        int k=0;
        ArrayList<Character>s=new ArrayList<>();
        ArrayList<Integer> order=new ArrayList<>();
        node[] nodes=new node[n];
        ArrayList<String>res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes[i]=new node(i+1);
        }
        for (int i = 0; i < n - 1; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            nodes[u-1].edges.add(nodes[v-1]);
            nodes[v-1].edges.add(nodes[u-1]);
        }
        {
            for (int i = 1; i < n; i++) {
                if (nodes[i].edges.size() == 1) {
                    k++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            order.add(in.nextInt());
        }

        nodes[0].isvisited++;
        s.add(' ');
        s.add('1');
        dfs(nodes[0],order.get(0),s,count,"");
        count++;
        for (int i = 0; i <order.size(); i++) {
            if(i==order.size()-1){
                nodes[order.get(i)-1].isvisited++;
                dfs(nodes[order.get(i)-1],1,s,count,"");
            }
            else {
                nodes[order.get(i)-1].isvisited++;
                dfs(nodes[order.get(i)-1],order.get(i+1),s,count,"");
            }

            count++;
        }
        for (int i = 0; i < s.size();i++) {
            if(s.get(i)!=' '){
                String temp="";
                while (i<s.size()&&s.get(i)!=' '){
                    temp=temp+s.get(i);
                    i++;
                }
                res.add(temp);
            }
        }
        if(res.size()<n*2) {
            for (String re : res) {
                out.print(re + " ");
                out.flush();
            }
        }


        else {
            out.print(-1);
            out.flush();
        }




    }
    public static void dfs(node root, int target, ArrayList<Character> arrayList, int count, String s){
        if(root==null){
            return ;
        }
        else if(root.index==target){
            for (int i = 0; i < s.length(); i++) {
                arrayList.add(s.charAt(i));
            }
            return;
        }
        else {
            for (int i = 0; i < root.edges.size(); i++) {
                if(root.edges.get(i).isvisited<count){
                    root.edges.get(i).isvisited++;
                    dfs(root.edges.get(i),target,arrayList,count,s+" "+root.edges.get(i).index);
                }
            }
        }
    }
    static class node{
        int isvisited=0;
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
