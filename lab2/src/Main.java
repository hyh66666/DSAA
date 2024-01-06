import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        int T=in.nextInt();
        int[] b=new int[T];
        for (int i = 0; i < T; i++) {
            b[i]=in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            int left=0,right=a.length-1,c=0;
            while (left<=right){
                int mid=left+(right-left)/2;
                if(b[i]==a[mid]){
                    System.out.println("YES");
                    c=1;
                    break;
                }
                else if(b[i]<a[mid]){
                    right=mid-1;
                }
                else left=mid+1;
            }
            if(c==0){
                System.out.println("NO");
            }
        }
    }
}
