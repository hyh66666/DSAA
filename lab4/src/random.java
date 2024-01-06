import java.util.Random;

public class random {
    public static void main(String[] args) {
        Random r = new Random();
        String a="hyhsygdsbmmdhxh";
        System.out.println(a);
        int n=10;
        System.out.println(n);
        for (int i=0;i<10;i++){
            int c=r.nextInt(3);
            if (c==0){
                System.out.print(c+1+" ");
                System.out.print('a'+" ");
                System.out.println(r.nextInt(a.length()+1));
            }
            if (c==1){
                System.out.print(c+1+" ");
                System.out.println(r.nextInt(a.length())+1);
            }
            if (c==2){
                System.out.print(c+1+" ");
                System.out.print(r.nextInt(a.length()/2)+1+" ");
                System.out.println(r.nextInt(a.length()/2)+a.length()/2+1);
            }
        }
    }
}
