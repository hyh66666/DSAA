import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainC {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int N=in.nextInt();
        int M=in.nextInt();
        int K=in.nextInt();
        long [] A=new long[N];
        long[] B=new long[M];
        for (int i = 0; i < N; i++) {
            A[i]=in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i]=in.nextInt();
        }
        Arrays.sort(B);
        smallest[] C=new smallest[N+1];
        for (int i = 1; i < N+1; i++) {
            C[i]=new smallest(A[i - 1] *B[0]);
            C[i].indexA=i-1;
        }
        BuildHeap(C);
        smallest temp=new smallest(1);;
        int cur=C.length-1;
        for (int i = 0; i < K; i++) {
            temp=Delete(C,cur);
            cur--;
            out.print(temp.value+" ");
            if(temp.indexB<B.length-1) {
                temp.value = A[temp.indexA] * B[temp.indexB + 1];
                temp.indexB++;
                Insertion(C,cur,temp);
                cur++;
            }
//            else if(temp.indexA!=A.length-1&&temp.indexB==B.length-1){
//                continue;
//            }
//            else {
//
//            }

        }






        out.close();




    }
    public static void BuildHeap(smallest [] C){
        int index;
        smallest temp=new smallest(1);
        for (int i = 1; i < C.length; i++) {
            index=i;
            while (index>1&&C[index/2].value>C[index].value){
                temp.value=C[index/2].value;
                temp.indexA=C[index/2].indexA;
                temp.indexB=C[index/2].indexB;
                C[index/2].indexA=C[index].indexA;
                C[index/2].indexB=C[index].indexB;
                C[index/2].value=C[index].value;
                C[index].indexA=temp.indexA;
                C[index].indexB=temp.indexB;
                C[index].value=temp.value;
                index=index/2;
            }

        }
    }
    public static smallest Delete(smallest[] array,int i){
        int index;
        smallest temp=new smallest(1),res=new smallest(1);
        res.value=array[1].value;
        res.indexB=array[1].indexB;
        res.indexA=array[1].indexA;
        array[1].value=array[i].value;
        array[1].indexA=array[i].indexA;
        array[1].indexB=array[i].indexB;
        index=1;
        //Go down
        while (2*index<=i-1){
            int  j=2*index;
            if(j<i-1&&array[j].value>array[j+1].value){
                j++;
            }
            if(array[index].value<array[j].value){
                break;
            }
            temp.indexA=array[index].indexA;
            temp.indexB=array[index].indexB;
            temp.value=array[index].value;
            array[index].indexA=array[j].indexA;
            array[index].indexB=array[j].indexB;
            array[index].value=array[j].value;
            array[j].value=temp.value;
            array[j].indexA=temp.indexA;
            array[j].indexB=temp.indexB;
//            temp=array[index];
//            array[index]=array[j];
//            array[j]=temp;
            index=j;
        }
        return res;
    }
    public static void Insertion(smallest[] array,int cur, smallest add){
        int index;
        smallest temp=new smallest(1);
        index=cur+1;
        array[index].value=add.value;
        array[index].indexB=add.indexB;
        array[index].indexA=add.indexA;
        //上浮
        while (index>1&&array[index/2].value>array[index].value){
            temp.indexA=array[index/2].indexA;
            temp.indexB=array[index/2].indexB;
            temp.value=array[index/2].value;
            array[index/2].indexA=array[index].indexA;
            array[index/2].indexB=array[index].indexB;
            array[index/2].value=array[index].value;
            array[index].indexA=temp.indexA;
            array[index].indexB=temp.indexB;
            array[index].value=temp.value;
            index=index/2;
        }

    }
    static class smallest{
        long value;
        int indexA=0;
        int indexB=0;
        public smallest(long value){
            this.value=value;
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
