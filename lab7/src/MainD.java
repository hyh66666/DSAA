import java.io.*;
import java.util.StringTokenizer;

public class MainD {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int T=in .nextInt();
        for (int i = 0; i < T; i++) {
            String a= in.next();
            String b=in.next();
            int count=1;
            for (int j = 0; j < a.length()-1; j++) {
                int x=b.indexOf(a.charAt(j));
                if(x<1){
                    continue;
                }
                if(a.charAt(j+1)==b.charAt(x-1)){
                    count=count*2;
                }
            }
            out.println(count);
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
