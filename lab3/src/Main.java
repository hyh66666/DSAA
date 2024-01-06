import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Long[]A=new Long[n];
//        Long b;
        for (int i = 0; i < n; i++) {
            A[i]=in.nextLong();
        }

        mergeSort(A);

//        for (int i = 0; i < n; i++) {
//            for (int j = i; j >0; j--) {
//                if(A[j-1]>A[j]){
//                    b=A[j-1];
//                    A[j-1]=A[j];
//                    A[j]=b;
//                }
//                else break;
//            }
//        }
        for (int i = 0; i < n; i++) {
            System.out.println(A[i]);
        }



//        if(n%2==0){
//            System.out.println(A[n/2]+A[n/2-1]);
//        }
//        if(n%2==1){
//            System.out.println(A[n/2]*2);
//        }



    }
    public static void mergeSort(Long[] arr){
        int length= arr.length;
        int mid=length/2;
        if(length>1){
            Long[]left= Arrays.copyOfRange(arr,0,mid);
            Long[]right=Arrays.copyOfRange(arr,mid,length);
            mergeSort(left);
            mergeSort(right);
            merge(arr,left,right);
        }
    }
    public static void merge(Long[]A,Long[]left,Long[]right){
        int i=0,j=0,n=0;
            while(i<left.length&&j<right.length){
                if(left[i]<right[j]){
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
                j++;
                n++;
            }

            while(i<left.length){
               A[n]=left[i];
                i++;
                n++;
            }
        }
}

