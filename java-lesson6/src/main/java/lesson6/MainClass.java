package lesson6;

//в главном классе создаются все животные и вызываются
//различные методы для каждого животного с разными параметрами

public class MainClass {
    public static void main (String[] args) {
Dog dog1 = new Dog();
dog1.run(100);
dog1.run(1000);
dog1.run(400);
dog1.run(500);
dog1.run(595);
       dog1.swim(5);
dog1.swim(15);
dog1.jump(0.1);
dog1.jump(0.9);
        Dog dog2 = new Dog();
        dog2.run(400);
        dog2.run(500);
        dog2.run(595);
Horse horse1 = new Horse();
        Horse horse2 = new Horse();
        Horse horse3 = new Horse();
horse1.run(100);
horse1.run(2000);
horse1.swim(50);
horse1.swim(110);
horse1.jump(2);
horse1.jump(5);
Bird bird1 = new Bird();
        Bird bird2 = new Bird();
bird1.run(1);
bird1.run(10);
bird1.swim(1);
bird1.jump(0.05);
bird1.jump(1.9);
Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
cat1.run(110);
cat1.run(300);
cat1.swim(1);
cat1.jump(1);
cat1.jump(5);

    }
}
