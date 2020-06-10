package lesson6;

public class Cat extends Animal {
    public static int lRunMax = 200;
    public static double hJumpMax = 2;
    public static int count = 0;

    @Override
    public void run(int lRun) {
        if (lRun < lRunMax) {
            System.out.println("Кот пробежал!");
        }
        else System.out.println("Слишком далеко бежать!");
    }

    @Override
    public void swim(int lSwim) {
        System.out.println("Кот не умеет плавать!");
    }

    @Override
    public void jump(double hJump) {
        if (hJump < hJumpMax) {
            System.out.println("Кот перепрыгнул!");
        }
        else System.out.println("Слишком далеко!");
    }

    public Cat() {
        count = count+1;
        System.out.println("Всего котов: " + count);
        super.count();
    }
}
