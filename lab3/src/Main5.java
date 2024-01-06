import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n,p,q,h,s;
        n=in.nextInt();
        p=in.nextInt();
        q=in.nextInt();
        ArrayList<Plan> arrayList =new ArrayList<>();
        ArrayList<Plan> arrayList1 =new ArrayList<>();
        ArrayList<Plan> arrayList2 =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            h=in.nextInt();
            s=in.nextInt();
            Plan plan=new Plan(h,s);
            arrayList.add(plan);
        }
        for (Plan plan : arrayList) {
            if (plan.getH() > plan.getS()) {
                arrayList1.add(plan);
            } else {arrayList2.add(plan);}
        }
//        for (Plan plan : arrayList1) {
//            System.out.println(plan.getH());
//        }
//        System.out.println();
//        mergeSort(arrayList1);
//        for (Plan plan : arrayList1) {
//            System.out.println(plan.getH());
//        }
        long result=result(arrayList1,arrayList2,p,q);
        out.print(result);
        out.flush();
    }
    public static long result(ArrayList<Plan> arrayList1,ArrayList<Plan> arrayList2,int p,int q){
        long result=0;
        int temp=q;
        for (int i = 0; i < arrayList1.size(); i++) {
            boolean flag=false;
            Plan plan1=arrayList1.get(i);
            long sum = 0;
            if(temp>0) {
                sum = arrayList1.get(i).getH() * (long) Math.pow(2, p);
                temp--;
                arrayList1.remove(i);
                flag=true;
            }
            ArrayList<Plan>A=new ArrayList<>(arrayList1);
            mergeSort(A);
            for (int j = A.size()-1; j >=0 ; j--) {
                if(temp>0) {
                    sum += A.get(j).getH();
                    temp--;
                }
                else {
                    sum+=A.get(j).getS();
                }
            }
            for (Plan plan : arrayList2) {
                sum += plan.getS();
            }
            temp=q;
            if(flag) {
                arrayList1.add(i, plan1);
            }
            if(sum>result){
                result=sum;
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            long sum = 0;
            boolean flag=false;
            Plan plan2=arrayList2.get(i);
            if(temp>0&&p>0) {
                sum = arrayList2.get(i).getH() * (long) Math.pow(2, p);
                if(sum<arrayList2.get(i).getS()){
                    sum=arrayList2.get(i).getS();
                }
                temp--;
                arrayList2.remove(i);
                flag=true;
            }
            ArrayList<Plan>A=new ArrayList<>(arrayList1);
            mergeSort(A);
            for (int j = A.size()-1; j >=0 ; j--) {
                if(temp>0) {
                    sum += A.get(j).getH();
                    temp--;
                }
                else {
                    sum+=A.get(j).getS();
                }
            }
            for (Plan plan : arrayList2) {
                sum += plan.getS();
            }
            temp=q;
            if(flag) {
                arrayList2.add(i, plan2);
            }
            if(sum>result){
                result=sum;
            }
        }
        return result;
    }
    static class Plan{
        private int h;
        private int s;

        public Plan(int h,int s){
            setH(h);
            setS(s);
        }
        public void setH(int h) {
            this.h = h;
        }
        public void setS(int s){
            this.s=s;
        }
        public int getH() {
            return h;
        }
        public int getS() {
            return s;
        }


    }


    public static void mergeSort(ArrayList<Plan> arrayList1){
        int length= arrayList1.size();
        int mid=length/2;
        if(length>1){
            ArrayList<Plan>left = new ArrayList<>();
            ArrayList<Plan>right = new ArrayList<>();
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




    public static void merge(ArrayList<Plan> arrayList1,ArrayList<Plan>left,ArrayList<Plan>right){
        int i=0,j=0,n=0;
        while(i<left.size()&&j<right.size()) {
                if (left.get(i).getH()-left.get(i).getS()<right.get (j).getH()-right.get (j).getS()){
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
            j++;
            n++;
        }

        while(i<left.size()){
            arrayList1.set(n,left.get(i));
            i++;
            n++;
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
