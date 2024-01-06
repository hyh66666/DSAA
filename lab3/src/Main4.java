import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n=in.nextInt();
        int[]A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=in.nextInt();
        }
        long result=minimum(A);
        out.println(result);
        out.flush();
    }
//    public static long minimum(int[]A){
//        int b;
//        long count=0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i; j >0; j--) {
//                if(A[j-1]>A[j]){
//                    b=A[j-1];
//                    A[j-1]=A[j];
//                    A[j]=b;
//                    count+= Math.min(A[j-1],A[j]);
//                }
//                else
//                    break;
//                }
//            }
//        for (int i = 0; i < A.length-1; i++) {
//            for (int j = 0; j < A.length-1; j++) {
//                if(A[j]>A[j+1]){
//                    b=A[j+1];
//                    A[j+1]=A[j];
//                    A[j]=b;
//                    count+= Math.min(A[j+1],A[j]);
//                }
//            }
//        }
//        return count;
//    }
    public static long minimum(int[] arr){
        long count=0;
        int length= arr.length;
        int mid=length/2;
        if(length>1){
            int[]left= Arrays.copyOfRange(arr,0,mid);
            int[]right=Arrays.copyOfRange(arr,mid,length);
            count+=minimum(left);
            count+=minimum(right);
            count+=merge(arr,left,right);

        }
        return count;
    }
    public static long merge(int[]A,int[]left,int[]right){
        int i=0,j=0,n=0;
        long count = 0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                A[n]=left[i];
                i++;
            }else{
                count+= (long) right[j] *(left.length-i);
                A[n]=right[j];
                j++;
            }
            n++;
        }
        while(j<right.length){
            A[n++]=right[j++];
        }
        while(i<left.length){
            A[n++]=left[i++];
        }
        return count;
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
