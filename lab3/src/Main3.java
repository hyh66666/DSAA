import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) {
        fastReader in = new fastReader();
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            int t=in.nextInt();
            int[]A=new int[t];
            int[]B;
            for (int j = 0; j < A.length; j++) {
                A[j]=in.nextInt();
            }
            B=Arrays.copyOfRange(A,0,t);
            long a=selection(A),
                    b=insertion(B);
            if(a>b){
                for (int j = 0; j < t; j++) {
                    out.print(B[j]+" ");
                }
                out.println();
                out.print("Insertion Sort wins!");
                out.println();
                out.flush();
            }
            if(a<b){
                for (int j = 0; j < t; j++) {
                    out.print(A[j]+" ");
                }
                out.println();
                out.print("Selection Sort wins!");
                out.println();
                out.flush();
            }
        }

    }
    public static long selection(int[] A){
        long a = 0;
        int b,k;
        for (int i = 0; i < A.length-1; i++) {
            k=i;
            for (int j = i+1; j <A.length ; j++) {
                if(A[k]>A[j]){
                    k=j;
                }
                a++;
            }
            b=A[i];
            A[i]=A[k];
            A[k]=b;
            a++;
        }
        return a;

    }
    public static long insertion(int[] A){
        long a = 0;
        int b;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j >0; j--) {
                if(A[j-1]>A[j]){
                    b=A[j-1];
                    A[j-1]=A[j];
                    A[j]=b;
                    a+=2;
                }
                else {
                    a++;
                    break;
                }
            }
        }
        return a;
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
