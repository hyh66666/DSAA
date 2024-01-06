import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) {
        fastReader in = new fastReader();
        int n=in.nextInt();
        int [][]c=new int[n][2];
        for (int i = 0; i < n; i++) {
            c[i][0]=in.nextInt();
            c[i][1]=in.nextInt();
            int[]A=new int[c[i][0]];
            int[]B=new int[c[i][1]];
            for (int j = 0; j <A.length ; j++) {
                A[j]=in.nextInt();
            }
            for (int j = 0; j < B.length; j++) {
                B[j]=in.nextInt();
            }
            long count=0;
            int[]C=new int[c[i][0]+c[i][1]];
            count=reversePair(C,A,B,count);
            out.println(count);
            out.flush();
            for (int k : C) {
                out.print(k+" ");
            }
            out.println();
            out.flush();

        }
    }
    public static long reversePair(int[]C, int[]A, int[]B, long count){
        int i=0,j=0,k=0;
            while (i<A.length&&j<B.length){
                if(A[i]<=B[j]){
                    C[k++]=A[i++];
                }
                else {
                    C[k++]=B[j++];
                    count+=A.length-i;
                }
            }
            while (i<A.length){
                C[k++]=A[i++];
            }
            while (j<B.length){
                C[k++]=B[j++];
            }
        return count;
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
    }
}
