import com.sun.org.apache.xpath.internal.operations.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generics {
    public static void main(String[] args) {
//        Pair<Integer> p = new Pair<>(123, 456);
//        int n = add(p);
//        System.out.println(n);
//        List<Integer> list =new ArrayList<>();
//        list.add()
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;

        System.out.println(ps.getClass() == Pair[].class); // true

        String s1 = (String) arr[0].getFirst();
        String s2 = ps[0].getFirst();
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
//        p.setFirst(new Number(first + 100));
//        p.setLast(new java.lang.Number(last.intValue() + 100));
//        return p.getFirst().intValue() + p.getFirst().intValue();
        return 0;
    }


}
class Person1 implements Comparable<Person1> {
    String name;
    int score;
    Person1(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Person1 other) {
        return other.score-this.score;
    }
    public String toString() {
        return this.name + "," + this.score;
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}
