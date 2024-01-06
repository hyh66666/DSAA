import java.util.Arrays;

public class test1 {
    public static void main(String[]args){
        int []A=new int[4];
        int[] left={3,4};
        int[] right={1,2};
        int i=1,j=1;
        int n=A.length;
        for (int k = 1; k <=n ; k++) {
            if(i<=n/2&&(j>n/2+1||left[i-1]<=right[j-1])){
                A[k-1]=left[i-1];
                i++;
            }
            else {
                A[k-1]=right[j-1];
                j++;
            }
        }
        System.out.println(Arrays.toString(A));
    }
}
