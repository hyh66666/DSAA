import java.util.Scanner;

public  class  test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Long[][] A = new Long[T][2];
        for (int i = 0; i < T; i++) {
            A[i][0] = in.nextLong();
            A[i][1] = in.nextLong();
        }
        for (int i = 0; i < T; i++) {
            long n = A[i][0];
            long m = A[i][1];
            long min =-(long) Math.pow(10,10);
            long max = (long) Math.pow(10,10);
            long mid;
            while (min<=max) {
                mid = min + (max - min) / 2;
                if (number(mid, n) >= m) {
                    max = mid - 1;
                }
                if (number(mid, n) < m ) {
                    min = mid + 1;
                }
            }
            System.out.println(min);
        }
    }

    public static double result(long n, int m) {
        return Math.pow(n, 2) + 12345 * n + Math.pow(m, 2) - 12345 * m + n * m;
    }
    public static long number(long value,long n){
        long count=0;
        for (int j = 0; j <n; j++) {
            long left = 0, right = n-1;
            while (left <= right) {
                long mid1 = (left+right)/2;
                if (result(mid1+1, j+1) <= value) {
                    left = mid1 + 1;
                }
                if (result(mid1+1, j+1) > value) {
                    right = mid1 - 1;
                }
            }
            count+=left;
        }
        return count;
    }
}
