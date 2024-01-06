import java.io.*;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        int [] swap=new int[n+1];
        int [] A=new int[n+1];
        int count,index,temp;
        for (int i = 1; i < n+1; i++) {
            count=0;
            A[i]=in.nextInt();
            index=i;
            while (index>1&&A[index/2]<A[index]){
                temp=A[index/2];
                A[index/2]=A[index];
                A[index]=temp;
                index=index/2;
                count++;
            }
            swap[i]=count;

        }
        for (int i = 1; i < n+1; i++) {
            out.print(swap[i]+" ");
            out.flush();
        }



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
