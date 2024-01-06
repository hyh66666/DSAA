import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class refletion {


    public static void main(String[] args) throws Exception {
        Person p = new Person("Xiao Ming");
        System.out.println(p.getName());

        Class c =  p.getClass();

        Class<String> c2=String.class;

        //动态更新私有字段
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(p, "new name xxxj");
        System.out.println(p.getName());


        // 动态调用私有方法
        Method m = c.getDeclaredMethod("setName", String.class);
        m.setAccessible(true);
        m.invoke(p, "setName called");
        System.out.println(p.getName());

        //动态调用构造方法
//        Constructor cons1 = c.getConstructor(String.class);
//        Person person2 = (Person) cons1.newInstance("name2");
//        System.out.println(person2.getName());
//
//        Constructor cons2 = c.getConstructor(String.class, int.class);
//        Person person3 = (Person) cons2.newInstance("name3", 123);
//        System.out.println(person3.getName());
//        System.out.println(person3.getAge());
//        Constructor cons3 = c.getDeclaredConstructor(int.class);
//        cons3.setAccessible(true);
//        Person person4 = (Person) cons3.newInstance(66);
//        System.out.println(person4.getAge());
        System.out.println(Arrays.toString(c.getConstructors()));
        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));
    }
}
class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(int age){
        this.age =age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        this.name = name;
    }
}
