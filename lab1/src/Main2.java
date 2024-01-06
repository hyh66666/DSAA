    import java.util.Scanner;

    public class Main2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a= in.nextInt();
            String[]b=new String[a];
            for (int i = 0; i < a; i++) {
                b[i]=in.next();
            }
            for (int i = 0; i < a; i++) {
                int c=0;
                for (int j = 0; j < b[i].length(); j++) {
                    if(b[i].charAt(j)=='1'||b[i].charAt(j)=='2'||b[i].charAt(j)=='3'||b[i].charAt(j)=='4'||b[i].charAt(j)=='5'||b[i].charAt(j)=='6'||b[i].charAt(j)=='7'||b[i].charAt(j)=='8'||b[i].charAt(j)=='9'){
                        System.out.println("no");
                        c=1;
                        break;
                    }
                }
                if(c==0){
                    System.out.println("yes");
                }
            }


        }

    }
