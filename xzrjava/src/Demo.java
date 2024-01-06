public class Demo {
    public static void run(Fruit fruit){
        fruit.show();

        if(fruit instanceof Apple){
            Apple apple = (Apple) fruit;
            apple.eatApple();
        }else if(fruit instanceof Orange){
            Orange orange = (Orange) fruit;
            orange.eatOrange();
        }else{
            Banana banana = new Banana();
            banana.eatBanana();
        }
    }
    public static void main(String[] args) {
        run(new Apple());
        run(new Orange());
        run(new Banana());
    }
}

abstract class Fruit{
    abstract void show();
}

class Apple extends Fruit{
    @Override
    public void show(){
        System.out.println("apple");
    }

    public void eatApple(){
        System.out.println("吃了一个apple");
    }
}

class Orange extends Fruit{
    @Override
    public void show(){
        System.out.println("orange");
    }

    public void eatOrange(){
        System.out.println("吃了一个orange");
    }
}

class Banana extends Fruit{
    @Override
    public void show(){
        System.out.println("banana");
    }

    public void eatBanana(){
        System.out.println("吃了一个banana");
    }
}
