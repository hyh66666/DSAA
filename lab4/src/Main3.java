import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int diff = 0;
        int n=in.nextInt();
        node[] A=new node[n];
        node[] B=new node[n];
        for (int i = 0; i < n; i++) {
            node a=new node(in.nextInt());
            A[i]=a;
            B[i]=a;
        }
        mergeSort(A);
        node head = new node(0);
        node cur=head;
        for (int i = 0; i < n; i++) {
            cur.next = A[i];
            A[i].pre = cur;
            cur = cur.next;
        }
        for (int i = 0; i < n-1; i++) {
                cur = B[i];
            if (cur.pre != head && cur.next != null) {
                int diff1=Math.abs(cur.next.a - cur.a);
                int diff2=Math.abs(cur.a - cur.pre.a);
                diff=Math.min(diff1,diff2);
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
            }
            if (cur.pre == head) {
                diff = cur.next.a - cur.a;
                head.next = cur.next;
                cur.next.pre = head;
            }
            if (cur.next == null) {
                diff = cur.a - cur.pre.a;
                cur.pre.next=null;
                cur.pre = null;
            }
            out.print(diff + " ");

//            out.print(A[i].a+" ");
//            if(cur.next!=null){
//                out.print(cur.next.a+" ");
//            }
        }
        out.flush();

    }
    public static void mergeSort(node[] A){
        int length= A.length;
        int mid=length/2;
        if(length>1){
            node[] left = Arrays.copyOfRange(A,0,mid);
            node[] right = Arrays.copyOfRange(A,mid,length);
            mergeSort(left);
            mergeSort(right);
            merge(A,left,right);
        }
    }
    public static void merge(node[]A,node[]left,node[]right) {
        int i=0,j=0,n=0;
        while(i<left.length&&j<right.length){
            if(left[i].a<=right[j].a){
                A[n]=left[i];
                i++;
            }else{
                A[n]=right[j];
                j++;
            }
            n++;
        }
        while(j<right.length){
            A[n]=right[j];
            n++;
            j++;
        }
        while(i<left.length){
            A[n]=left[i];
            n++;
            i++;
        }
    }

    static class node{
        int a;
        node next;
        node pre;
        public node(int a) {
            this.a=a;
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
        long nexLong(){return Long.parseLong(next());}
    }
}
