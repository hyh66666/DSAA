import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) {
        fastReader in = new fastReader();
        int n=in.nextInt();
        int t=0;
        int []A=new int[n];
        int[]B=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=in.nextInt();
        }
        mergeSort(A);
        int m=n-1;

        for (int i = 0; i <n ; i+=2) {
            B[i]=A[t++];
            if(i+1<n) {
                B[i + 1] = A[m--];
            }
        }
//        for (int i = 0,j1=0,j2=(n+1)/2; i <n ; i++) {
//            if((i&1)==0){
//                B[i]=A[j1++];
//            }
//            else {
//                B[i]=A[j2++];
//            }
//        }
        for (int i = 0; i < n; i++) {
            out.print(B[i]+" ");
        }
        out.flush();

    }
    public static void mergeSort(int[] arr){
        int length= arr.length;
        int mid=length/2;
        if(length>1){
            int[]left= Arrays.copyOfRange(arr,0,mid);
            int[]right=Arrays.copyOfRange(arr,mid,length);
            mergeSort(left);
            mergeSort(right);
            merge(arr,left,right);
        }
    }
    public static void merge(int[]A,int[]left,int[]right) {
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