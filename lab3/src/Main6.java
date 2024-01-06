import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main6 {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        int n,p,q,h,s;
        n=in.nextInt();
        p=in.nextInt();
        q=in.nextInt();
        long sum = 0;
        ArrayList<Plant> arrayList =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            h=in.nextInt();
            s=in.nextInt();
            Plant plant =new Plant(h,s);
            arrayList.add(plant);
        }
        mergeSort(arrayList);
        int cnt = 0;
        for (Plant plant : arrayList) {
           if (plant.getDiff() > 0) {
               cnt++;
           }
           sum += plant.getS();
        }

        if(q < 1) {
            out.println(sum);
            out.flush();
            return;
        }
        long pow=(long)Math.pow(2,p);

        long max=0;
        if(q>cnt){
            for (Plant plant : arrayList) {
                long temp = 0;
                if (plant.getDiff() > 0) {
                    temp=pow*plant.getH()-plant.getS()-plant.getDiff();
                }
                else {
                    temp=pow*plant.getH()-plant.getS();
                }
                if(max<temp){
                    max=temp;
                }
            }
        } else {
            for (int i = 0; i < q; i++) {
                Plant plant = arrayList.get(i);
                long temp = pow*plant.getH()-plant.getS()-plant.getDiff();
                if (max < temp) {
                    max = temp;
                }
            }
            for (int i = q; i < n; i++) {
                Plant plant = arrayList.get(i);
                long temp = pow*plant.getH()-plant.getS()-arrayList.get(q-1).getDiff();
                if (max < temp) {
                    max = temp;
                }
            }
        }

        int needCnt = Math.min(q, cnt);
        for (int i = 0; i < needCnt; i++) {
            sum += arrayList.get(i).getDiff();
        }

        sum += max;
        out.println(sum);
        out.flush();
    }

    public static void mergeSort(ArrayList<Plant> arrayList1){
        int length= arrayList1.size();
        int mid=length/2;
        if(length>1){
            ArrayList<Plant>left = new ArrayList<>();
            ArrayList<Plant>right = new ArrayList<>();
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
    public static void merge(ArrayList<Plant> arrayList1, ArrayList<Plant>left, ArrayList<Plant>right){
        int i=0,j=0,n=0;
        while(i<left.size()&&j<right.size()) {
            if (left.get(i).getDiff() >right.get (j).getDiff()){
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
    static class Plant {
        private int h;
        private int s;
        private int diff;

        public Plant(int h, int s){
            setH(h);
            setS(s);
            this.diff=h-s;
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

        public int getDiff() {
            return diff;
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
