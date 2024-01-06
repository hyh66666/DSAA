import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        City result;
        City[] cities=new City[n+1];
        for (int i = 0; i < n+1; i++) {
            cities[i]=new City();
            cities[i].index=i;
            cities[i].idx=i;
        }
        for (int i = 0; i < m; i++) {
            int u=in.nextInt();
            int v=in.nextInt();
            int w=in.nextInt();
            cities[u].cities.add(cities[v]);
            cities[u].cost.add(w);
        }
        cities[1].value=0;
        result=cities[n];
        minimum(cities);
        if(result.value==Math.pow(10,15)){
            out.println(-1);
        }
        else {
            out.println(result.value);
        }
        out.close();
    }
    public static void minimum(City[]cities){
        int cur=cities.length-1;
        City temp,temp1;
        int temp_idx;
        while (cur>0){
            temp=stDelete(cities,cur);
            cur--;
            for (int i = 0; i < temp.cities.size(); i++) {
                if(temp.cities.get(i).value> temp.value+temp.cost.get(i)){
                    temp.cities.get(i).value= temp.value+temp.cost.get(i);
                    // go up
                    int index=temp.cities.get(i).index;
                    while (index>1&&cities[index/2].value>cities[index].value){
                        temp1=cities[index];
                        cities[index]=cities[index/2];
                        cities[index/2]=temp1;
                        temp_idx=cities[index].index;
                        cities[index].index=cities[index/2].index;
                        cities[index/2].index=temp_idx;

                        index=index/2;
                    }

                }
            }
        }

    }
    public static City stDelete(City[] cities,int cur){
        int index,temp_idx;
        int res=cur;
        City temp;
        temp=cities[1];
        cities[1]=cities[cur];
        cities[cur]=temp;
        cities[1].index=cities[cur].index;


        cur--;
        index=1;
        //Go down
        while (2*index<=cur){
            int  j=2*index;
            if(j<cur&&cities[j].value>cities[j+1].value){
                j++;
            }
            if(cities[index].value<cities[j].value){
                break;
            }
            temp=cities[j];
            cities[j]=cities[index];
            cities[index]=temp;
            temp_idx=cities[index].index;
            cities[index].index=cities[j].index;
            cities[j].index=temp_idx;
            index=j;
        }
        return cities[res];
    }
    static class City{
        long value= (long) Math.pow(10,15);
        int index;
        int idx;
        ArrayList<Integer> cost=new ArrayList<>();
        ArrayList<City> cities=new ArrayList<>();
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
