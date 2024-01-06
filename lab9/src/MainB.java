import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainB {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for (int i = 0; i < T; i++) {
            String a=in.next();
            String b=in.next();
            point start=new point(a.charAt(0)-'a'+1,a.charAt(1)-'0');
            point end=new point(b.charAt(0)-'a'+1,b.charAt(1)-'0');
            int[][] dir=new int[][]{{1,2},{2,1},{1,-2},{-2,1},{-1,2},{2,-1},{-2,-1},{-1,-2}};
            int[][] chessboard=new int[8][8];
            if(a.equals(b)){
                out.println(0);
            }
            else {
                out.println(bfs(start,end,dir,chessboard));
            }

        }
        out.close();
    }
    public static int bfs(point start,point end,int[][] dir,int[][] chessboard){
        Queue<point> queue= new LinkedList<>();
        queue.add(start);
        chessboard[start.x-1][start.y-1]=1;
        while (queue.size()!=0){
            point temp=queue.peek();
            queue.poll();
            if(temp.x==end.x&&temp.y==end.y){
                return temp.step;
            }
            for (int i = 0; i < 8; i++) {
                point next=new point(temp.x+dir[i][0], temp.y+dir[i][1]);
                next.step=temp.step+1;
                if(next.x<1||next.x>8||next.y<1||next.y>8){
                    continue;
                }
                if(chessboard[next.x-1][next.y-1]==1){
                    continue;
                }
                queue.add(next);
            }


        }


    return  0;


    }
    static class point{
        int x;
        int y;
        int step=0;
        public point(int x,int y){
            this.x=x;
            this.y=y;
        }
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
