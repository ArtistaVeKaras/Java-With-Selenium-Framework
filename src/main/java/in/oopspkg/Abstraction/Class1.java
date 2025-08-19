package in.oopspkg.Abstraction;

public class Class1 {

    public static void main(String[] args) {

        Animal a1 = new Dog();
        a1.walk();
        a1.eat();

        Dog d1 = new Dog();
        d1.walk();
        d1.eat();

        Cat c1 = new Cat();
        c1.walk();
        c1.meow();
    }
}