import java.io.*;
import java.util.StringTokenizer;

public class MainB {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        String s=in.next();
        StringBuilder temp= new StringBuilder();
        int[][] state=new int[s.length()][26];
        int x=0;
        for (int i = 0; i < s.length(); i++) {
            if(!temp.toString().contains(s.substring(i,i+1))){
                temp.append(s.charAt(i));
            }
            else {
                continue;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j)==s.charAt(i)){
                    state[i][(int)s.charAt(i)-'a']=i+1;
                }
                else {
                    state[i][(int)temp.charAt(j)-'a']=state[x][(int)temp.charAt(j)-'a'];
                }

            }
            if(i>=1) {
                x = state[x][(int) s.charAt(i) - 'a'];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                out.print(state[i][j]+" ");
            }
            out.print("\n");
        }
        out.flush();


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
