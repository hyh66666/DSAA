import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainD2 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        long []A=new long[n+1];
        for (int i = 1; i <n+1 ; i++) {
            A[i]=in.nextInt();
        }
        mergeSort(A);
        int cur=A.length-1;
        long temp1,temp2;
        long result=0;
        while (cur>1){
            temp1=Delete(A,cur);
            cur--;
            temp2=Delete(A,cur);
            cur--;
            result+=temp1+temp2;
            Insertion(A,cur,temp1+temp2);
            cur++;
        }
        out.println(result);
        out.close();




    }
    public static void Insertion(long[] array,int cur, long add){
        int index;
        long temp;
        index=cur+1;
        array[index]=add;
        //上浮
        while (index>1&&array[index/2]>array[index]){
            temp=array[index/2];
            array[index/2]=array[index];
            array[index]=temp;
            index=index/2;
        }

    }
    public static long Delete(long[] array,int i){
        int index;
        long temp;
        long res;
        res=array[1];
        array[1]=array[i];
        array[i]=0;
        index=1;
        //下沉
        while (2*index<=i-1){
            int  j=2*index;
            if(j<i-1&&array[j]>array[j+1]){
                j++;
            }
            if(array[index]<array[j]){
                break;
            }
            temp=array[index];
            array[index]=array[j];
            array[j]=temp;
            index=j;
        }
            return res;
    }
    public static void mergeSort(long[] arr){
        int length= arr.length;
        int mid=length/2;
        if(length>1){
            long[]left= Arrays.copyOfRange(arr,0,mid);
            long[]right=Arrays.copyOfRange(arr,mid,length);
            mergeSort(left);
            mergeSort(right);
            merge(arr,left,right);
        }
    }
    public static void merge(long[]A,long[]left,long[]right) {
        int i = 0, j = 0;
        for (int k = 0; k < A.length; k++) {
            if (i <= left.length - 1 && (j > right.length - 1 || left[i] <= right[j])) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
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
