import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MainE {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        boolean isEven=true;
        ArrayList<Integer> stHeap=new ArrayList<>();
        ArrayList<Integer> btHeap=new ArrayList<>();
        stHeap.add(0);
        btHeap.add(0);
        int a;
        for (int i = 0; i < n; i++) {
            a=in.nextInt();
                create(a,stHeap,btHeap,isEven);
                isEven=!isEven;
                if (isEven) {
                    out.print(btHeap.get(1) + " ");
                } else {
                    out.print(stHeap.get(1) + " ");
                }

        }
        out.close();




    }
    public static void create(int m,ArrayList<Integer> stHeap,ArrayList<Integer> btHeap,boolean isEven){
        int temp;
        // the numbers of Big top heap are even
        if(isEven){




                btInsertion(btHeap, m);
                temp = btDelete(btHeap);
                stInsertion(stHeap, temp);


        }
        else {


                stInsertion(stHeap, m);
                temp = stDelete(stHeap);
                btInsertion(btHeap, temp);


        }

    }
    public static int stDelete(ArrayList<Integer> array){
        int index,res;
        res=array.get(1);
        Collections.swap(array,1,array.size()-1);
        array.remove(array.size()-1);
        index=1;
        //Go down
        while (2*index<array.size()){
            int  j=2*index;
            if(j<array.size()-1&&array.get(j)>array.get(j+1)){
                j++;
            }
            if(array.get(index)<array.get(j)){
                break;
            }
            Collections.swap(array,index,j);
            index=j;
        }
        return res;
    }
    public static void stInsertion(ArrayList<Integer> array, int add){
        int index;
        index=array.size();
        array.add(add);
        //上浮
        while (index>1&&array.get(index/2)>array.get(index)){
            Collections.swap(array,index,index/2);
            index=index/2;
        }

    }
    public static int btDelete(ArrayList<Integer> array){
        int index,res;
        res=array.get(1);
        Collections.swap(array,1,array.size()-1);
        array.remove(array.size()-1);
        index=1;
        //Go down
        while (2*index<array.size()){
            int  j=2*index;
            if(j<array.size()-1&&array.get(j)<array.get(j+1)){
                j++;
            }
            if(array.get(index)>array.get(j)){
                break;
            }
            Collections.swap(array,index,j);
            index=j;
        }
        return res;
    }
    public static void btInsertion(ArrayList<Integer> array, int add){
        int index;
        index=array.size();
        array.add(add);
        //上浮
        while (index>1&&array.get(index/2)<array.get(index)){
            Collections.swap(array,index,index/2);
            index=index/2;
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
