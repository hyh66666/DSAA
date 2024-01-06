import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainD {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n =in.nextInt();
        int[]A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=in.nextInt();
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        node root=createTree(A);
        out.println(root.value);
        out.flush();
        preorder(root,arrayList);
        long res=0;
        for (Integer integer : arrayList) {
            res += integer;
        }
        out.println(res);
        out.flush();
    }


    static class node{
        int value;
        node left;
        node right;
        public node(int a) {
            this.value=a;
        }

    }


    public static node createTree(int[] array){
        ArrayList<node>nodes=new ArrayList<>();
        for (int j : array) {
            nodes.add(new node(j));
        }
        mergeSort(nodes);
        while (nodes.size()>1){

            node totNode=new node(nodes.get(0).value+nodes.get(1).value);
            totNode.left=nodes.get(0);
            totNode.right=nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            if(nodes.size()==0){
                nodes.add(totNode);
            }
            else {
                for (int i = 0; i < nodes.size(); i++) {
                    if (totNode.value <= nodes.get(i).value) {
                        nodes.add(i, totNode);
                        break;
                    }
                    if (totNode.value > nodes.get(i).value && i == nodes.size() - 1) {
                        nodes.add(totNode);
                    }
                }
            }

        }
        return nodes.get(0);


    }
    public static void mergeSort(ArrayList<node> arrayList1){
        int length= arrayList1.size();
        int mid=length/2;
        if(length>1){
            ArrayList<node>left = new ArrayList<>();
            ArrayList<node>right = new ArrayList<>();
            for (int i = 0; i < mid; i++) {
                left.add(arrayList1.get(i));
            }
            for (int i = mid; i < length; i++) {
                right.add(arrayList1.get(i));
            }
            mergeSort(left);
            mergeSort(right);
            merge(arrayList1,left,right);
        }
    }




    public static void merge(ArrayList<node> arrayList1,ArrayList<node>left,ArrayList<node>right){
        int i=0,j=0,n=0;
        while(i<left.size()&&j<right.size()){
            if(left.get(i).value<=right.get(j).value){
                arrayList1.set(n,left.get(i));
                i++;
            }else{
                arrayList1.set(n,right.get(j));
                j++;
            }
            n++;
        }
        while(j<right.size()){
            arrayList1.set(n,right.get(j));
            n++;
            j++;
        }
        while(i<left.size()){
            arrayList1.set(n,left.get(i));
            n++;
            i++;
        }
    }
    public static void preorder(node root, ArrayList<Integer> arrayList){
        if(root.left!=null&&root.right!=null){
            arrayList.add(root.value);
        }
        if(root.left!=null){
            preorder(root.left,arrayList);
        }
        if(root.right!=null){
            preorder(root.right,arrayList);
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
