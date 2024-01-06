

import java.io.*;
import java.util.StringTokenizer;

public class MainF {
    public static void main(String[] args) {
        fastReader in=new fastReader();
        String s=in.next();
        int len=(int)Math.sqrt(s.length());
        Node head=new Node();
        Node temp=head;
        int j=s.length();
        int k=0;
        while(j!=0){
            if (j>=len){
                Node a=new Node();
                for (int i=0;i<len;i++){

                    a.ch[i]=s.charAt(k*len+i);
                    a.count++;
                }
                temp.next=a;
                k++;
                j-=len;
                temp=temp.next;
            }
            else {
                Node a=new Node();
                for (int i=0;i<j;i++){
                    a.ch[i]=s.charAt(k*len+i);
                    a.count++;
                }
                temp.next=a;
                j=0;
            }
        }
        int n= in.nextInt();
        for (int i = 0; i < n; i++) {
            int m=in.nextInt();
            if(m==1){
                Insert(in.next().charAt(0),in.nextInt(),head,s);
            }
            if(m==2){
                char result=Find(in.nextInt(),head);
                out.println(result);
                out.flush();
            }
            if(m==3){
                Transform(in.nextInt(), in.nextInt(), head);
            }
        }
//        temp=head;
//        while (temp.next!=null){
//            out.print(temp.next.count+" ");
//            for (int i = 0; i < temp.next.count; i++) {
//                out.print(temp.next.ch[i]+" ");
//            }
//            out.flush();
//            temp=temp.next;
//        }
    }

    public static void Insert(char ch,int p,Node head,String s){
        Node temp=head;
        while (p>0){
            temp=temp.next;
            p-=temp.count;
        }
        int index=p+ temp.count;
        if (temp.count - (index - 1) >= 0)
            System.arraycopy(temp.ch, index - 1, temp.ch, index, temp.count - (index - 1));
        temp.ch[index-1]=ch;
        temp.count++;
        int count= temp.count;
        if(temp.count==2*(int)Math.sqrt(s.length())){
            Node a=new Node();
            for (int i = (int)Math.sqrt(s.length()); i <count ; i++) {
                a.ch[a.count++]=temp.ch[i];
                temp.count--;
                if(temp.next!=null) {
                    a.next = temp.next;
                }
                temp.next = a;
            }
        }
    }
    public static char Find(int p,Node head){
        Node temp=head;
        while (p > 0) {
            temp=temp.next;
            p-=temp.count;
        }
        if(temp.flag%2!=0){
            temp.ch[p+temp.count-1]= (char) ('a'+'z'-temp.ch[p+temp.count-1]);
        }
        return temp.ch[p+temp.count-1];
    }
    public static void Transform(int p,int p1,Node head){
        Node temp=head;
        while (p>0){
            temp=temp.next;
            p-=temp.count;
        }
        Node temp1=head;
        while (p1>0){
            temp1=temp1.next;
            p1-=temp1.count;
        }
            if(temp==temp1) {
                for (int i = p + temp.count - 1; i < p1 + temp1.count; i++) {
                    temp.ch[i] = (char) ('a' + 'z' - temp.ch[i]);
                    }
                }
            else {
                for (int i = p + temp.count - 1; i < temp.count; i++) {
                    temp.ch[i] = (char) ('a' + 'z' - temp.ch[i]);
                    }
                for (int i = p1+ temp1.count-1; i >=0 ; i--) {
                    temp1.ch[i]=(char) ('a'+'z'-temp1.ch[i]);
                    }
                while (temp.next!=temp1){
                    temp.next.flag+=1;
                    temp=temp.next;
                }
                }

    }
    static class Node{
        char[] ch=new char[10000];
        int count=0;
        Node next;
        int flag=0;
        public Node(){
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
