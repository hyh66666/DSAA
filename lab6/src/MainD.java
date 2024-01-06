import java.util.Scanner;
public class MainD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        if (rotateString2(s, t)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }


//    public static boolean rotateString1(String s, String t) {
//        String temp = s + s;
//        if (s.equals(t)) {
//            return true;
//        }
//        if (s.length() == t.length()) {
//            int d = 128, q = 431;
//            int h = 1;
//            for (int i = 0; i < t.length() - 1; i++) {
//                h = (h * d) % q;
//            }
//            int p = 0, l = 0;
//            for (int i = 0; i < t.length(); i++) {
//                p = (d * p + t.charAt(i)) % q;
//                l = (d * l + temp.charAt(i)) % q;
//            }
//            for (int i = 0; i < temp.length() - t.length(); i++) {
//                int c = (temp.charAt(i + t.length()));
//                int i1 = (temp.charAt(i)) * h;
//                if (p != l) {
//                    l = (d * (l - i1) + c) % q;
//                    if (l < 0) {
//                        l = l + q;
//                    }
//                } else {
//                    if (t.equals(temp.substring(i, i + t.length()))) {
//                        return true;
//                    } else {
//                        l = (d * (l - i1) + c) % q;
//                        if (l < 0) {
//                            l = l + q;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static boolean rotateString2(String s,String t){
        if(s.equals(t)){
            return true;
        }
        if(s.length()==t.length()) {
            String temp = s + s;
            int q = 0;
            int[] next = next(t);
            for (int i = 0; i < temp.length(); i++) {
                while (q > 0 && t.charAt(q) != temp.charAt(i)) {
                    q = next[q - 1];
                }
                if (t.charAt(q) == temp.charAt(i)) {
                    q += 1;
                }
                if (q == t.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] next(String s){
        int []next=new int[s.length()];
        int k=0;
        for (int i = 1; i <s.length(); i++) {
            while (k>0&&s.charAt(k)!=s.charAt(i)){
                k=next[k-1];
            }
            if(s.charAt(k)==s.charAt(i)){
                k+=1;
            }
            next[i]=k;
        }
        return next;
    }
}
