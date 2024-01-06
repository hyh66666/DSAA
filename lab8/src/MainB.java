import java.io.*;
import java.util.StringTokenizer;

public class MainB {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int[] A=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            A[i]=in.nextInt();
        }
        if(isMax(A)){
            out.print("Max");
        }
        else if(isMin(A)){
            out.print("Min");
        }
        else {
            out.print("Neither");
        }
        out.close();
    }
    public static boolean isMax(int[] A){
        boolean flag=true;
        int length;
        if(A.length/2==0){
            length=A.length/2-1;
        }
        else {
            length=A.length/2;
        }
        for (int i = 1; i < length; i++) {
            if(A[i]<A[i*2]||A[i]<A[i*2+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static boolean isMin(int[] A){
        boolean flag=true;
        int length;
        if(A.length/2==0){
            length=A.length/2-1;
        }
        else {
            length=A.length/2;
        }
        for (int i = 1; i < length; i++) {
            if(A[i]>A[i*2]||A[i]>A[i*2+1]){
                flag=false;
                break;
            }
        }
        return flag;
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
