import java.util.Random;

import java.util.ArrayList;
import java.util.List;
    public class ll {

        public static void main(String[] args) {
            int n = 10;
            int h = 500;
            final int count = 100;
            final int[] an = new int[n];
            final int[] bn = new int[n];
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                System.out.printf("--- DataSet %d ---\n", i);
                System.out.printf("%d %d\n", n, h);
                for (int j = 0; j < n - 1; j++) {
                    an[j] = random.nextInt(h - 1) + 1; // [1, h]
                    bn[j] = random.nextInt(h - 1) + 1; // [1, h]
                }
                for (int j = 0; j < n - 1; j++)
                    System.out.printf("%d ", an[j]);
                System.out.println();
                for (int j = 0; j < n - 1; j++)
                    System.out.printf("%d ", bn[j]);
                System.out.println();
                List<Ans> ansList = new ArrayList<>();
                int min_ab = Integer.MAX_VALUE;
                for (int j = 1; j <= h; j++) {
                    for (int k = 1; k <= h; k++) {
                        an[n - 1] = j;
                        bn[n - 1] = k;
                        // test for an and bn
                        if (test(an, bn)) {
                            int minified = an[n - 1] - bn[n - 1];
                            if (minified < min_ab) {
                                min_ab = minified;
                                ansList.add(new Ans(an[n - 1], bn[n - 1]));
                                ansList.removeIf(ans -> ans.worse(an[n - 1], bn[n - 1]));
                            }
                        }
                    }
                }
                if (min_ab == Integer.MAX_VALUE)
                    System.out.println("IMPOSSIBLE");
                else {
                    System.out.printf("%d\nansList: %s\n", min_ab, ansList);
                }
                System.out.println();
            }
        }

        static class Ans {
            int an;
            int bn;

            public Ans(int an, int bn) {
                this.an = an;
                this.bn = bn;
            }

            @Override
            public String toString() {
                return "Ans{" +
                        "an=" + an +
                        ", bn=" + bn +
                        '}';
            }

            public boolean worse(int a, int b) {
                return an - bn > a - b;
            }
        }

        private static boolean test(int[] an, int[] bn) {
            int a_min, a_max = 0, a_sum = 0;
            int b_min, b_max = 0, b_sum = 0;
            a_min = an[0];
            b_min = bn[0];
            for (int i = 0; i < an.length; i++) {
                if (an[i] > a_max)
                    a_max = an[i];
                if (an[i] < a_min)
                    a_min = an[i];
                a_sum += an[i];

                if (bn[i] > b_max)
                    b_max = bn[i];
                if (bn[i] < b_min)
                    b_min = bn[i];
                b_sum += bn[i];
            }
            a_sum -= a_max + a_min;
            b_sum -= b_max + b_min;
            return a_sum > b_sum;
        }
    }

