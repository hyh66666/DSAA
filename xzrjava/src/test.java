import java.awt.font.ShapeGraphicAttribute;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) throws Exception {
//        try {
//            process1();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Person p = new Person();
//        System.out.println(p.address.city.toLowerCase());
//        String s = null;
//        Logger logger = Logger.getLogger(Main.class.getName());
//        logger.info("Start process...");
//        try {
//            s.toLowerCase();
//        } catch (NullPointerException e) {
//            // TODO: 使用logger.severe()打印异常
////            logger.severe(()->{e.printStackTrace();    return null;});
//            logger.severe(e.toString());
//        }
//        logger.info("Process end.");

        // 获取String的Class实例:
//        Class cls = String.class;
//// 创建一个String实例:
//        String s = (String) cls.newInstance();


        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

//        printClassInfo("".getClass());
//        printClassInfo(Runnable.class);
//        printClassInfo(java.time.Month.class);
//        printClassInfo(String[].class);
//        printClassInfo(int.class);

//        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
//        System.out.println(stdClass.getMethod("getScore", String.class,int.class));
        // 获取继承的public方法getName，无参数:
//        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
//        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
    }

//    class Student extends Person {
//        public int getScore(String type,int n ) {
//            return 99;
//        }
//        private int getGrade(int year) {
//            return 1;
//        }
//    }

//    class Person {
//        public String getName() {
//            return "Person";
//        }
//    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }


    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null); // 会抛出NumberFormatException
    }




    public static int getNumber(int num){
        try{
            int result = 2 / num;
            return result;
        }catch (Exception exception){
            return 0;
        }finally{
            if(num == 0){
                return -1;
            }
            if(num == 1){
                return 1;
            }
        }
    }
//    public static void main(String[] args) {
//        Person ming = new Person("Xiao Ming", 12);
//        Person hong = new Person("Xiao Hong", 15);
//        ming.number = 88;
//        System.out.println(hong.number);
//        hong.number = 99;
//        System.out.println(ming.number);
//        StringBuilder sb=new StringBuilder();
////        Integer n=Integer.valueOf();
//        Map<String,String> map =new HashMap<>();
//        System.out.println(Weekday.MON.name());
////        BigInteger n = new BigInteger("999999").pow(99);
////        float f = n.floatValue();
////        System.out.println(n);
//
//        BigDecimal d1 = new BigDecimal("123.456");
//        BigDecimal d2 = new BigDecimal("23.456789");
//        BigDecimal d3=d1.subtract(d2);
//        System.out.println(d3);
//
//        Random r = new Random(12345);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(100));
//        }
//        "111".getBytes(StandardCharsets.UTF_8);
//
////        double x = Math.random(); // x的范围是[0,1)
////        double min = 10;
////        double max = 50;
////        double y = x * (max - min) + min; // y的范围是[10,50)
////        long n = (long) y; // n的范围是[10,50)的整数
////        System.out.println(y);
////        System.out.println(n);
//
////    public static long gcd(long a,long b){
////        if(b==0){
////            return a;
////        }
////        else return gcd(b,a%b);
////    }
////    public static void exgcd(long a,long b){
////        long result,temp;
////        if(b==0){
////            x=1;
////            y=0;
////            return;
////        }
////        exgcd(b,a%b);
////        temp=x;
////        x=y;
////        y=temp-a/b*y;
////    }
//    }


}

//class Person {
//    String[] name = new String[2];
//    Address address = new Address();
//}

class Address {
    String city;
    String street;
    String zipcode;
}
//     class  Person {
//    public String name;
//    public  int age;
//
//    public static  int number;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//        name.toLowerCase();
//    }
//}
enum Weekday {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}


