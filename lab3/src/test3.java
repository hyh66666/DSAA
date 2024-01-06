import java.util.Random;

public class test3{
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            int n = r.nextInt(20)+1;
            int p = r.nextInt(0);
            int q = r.nextInt(200001);
            System.out.println(n+" "+p+" "+q+" ");
            for (int j = 0; j < n; j++) {
                int h = r.nextInt(1000000000)+1;
                int s = r.nextInt(1000000000)+1;
                System.out.println(h+" "+s);
            }
            System.out.println();
        }
    }
}

