import java.io.*;
import java.util.StringTokenizer;

public class MainD1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Node[][] mat = new Node[n][m];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    mat[j][k] = new Node();
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    mat[j][k] .value= in.nextInt();
                }
            }

            long result=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    result=Math.max(result,dfs(mat,j,k));
                }
            }
            out.println(result);
        }
        out.close();
    }

    public static long dfs(Node[][] mat,int row,int col) {
        int bottom=mat.length;
        int right=mat[0].length;
        long result=0;
        long dir=0,dir1=0;
        if(isOption(mat,row,col)){
            mat[row][col].isVisit=true;
            result+=mat[row][col].value;
            if(col<right-1){
                dir+=dfs(mat,row,col+1);
            }
            if(col==right-1&&row<bottom-1){
                dir+=dfs(mat,row+1,0);
            }
            mat[row][col].isVisit=false;
            if(col<right-1){
                dir1+=dfs(mat,row,col+1);
            }
            if(col==right-1&&row<bottom-1){
                dir1+=dfs(mat,row+1,0);
            }
            result=Math.max(result+dir,dir1);

        }
        else {
            if(col<right-1){
                result+=dfs(mat,row,col+1);
            }
            if(col==right-1&&row<bottom-1){
                result+=dfs(mat,row+1,0);
            }
        }
        return result;
    }


    public static boolean isOption(Node[][] mat,int row, int col) {
        int right = mat[0].length;
        int bottom =mat.length;
        // dow
        if (row < bottom - 1 && mat[row + 1][col].isVisit) {
            return false;
        }
        // up
        else if(row>0&&mat[row-1][col].isVisit){
            return false;
        }
        //left
        else if(col>0&&mat[row][col-1].isVisit){
            return false;
        }
        // right
        else if(col<right-1&&mat[row][col+1].isVisit){
            return false;
        }
        //left and up
        else if(col>0&&row>0&&mat[row-1][col-1].isVisit){
            return false;
        }
        // left and down
        else if(col>0&&row<bottom-1&&mat[row+1][col-1].isVisit){
            return false;
        }
        //right and up
        else if(col<right-1&&row>0&&mat[row-1][col+1].isVisit){
            return false;
        }
        // right and down
        else if(col<right-1&&row<bottom-1&&mat[row+1][col+1].isVisit){
            return false;
        }
        // self
        else return !mat[row][col].isVisit;
    }

    static class Node{
        int value;
        boolean isVisit=false;

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
        }
    }

}