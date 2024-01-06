import java.io.*;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for (int i = 0; i < T; i++) {
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] A=new int[n][n];
            for (int j = 0; j < m; j++) {
                int u=in.nextInt();
                int v=in.nextInt();
                A[u-1][v-1]++;
            }
            for (int[] ints : A) {
                for (int k = 0; k < n; k++) {
                    out.print(ints[k] + " ");
                }
                out.print("\n");
            }
        }
        out.close();
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
