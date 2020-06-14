package lesson6;

public class Bird extends Animal {
    public static int lRunMax = 5;
    public static double hJumpMax = 0.1;
    public static int count = 0;

    @Override
    public void run(int lRun) {
        if (lRun < lRunMax) {
            System.out.println("Птица пробежала!");
        }
        else System.out.println("Слишком далеко бежать!");
    }

    @Override
    public void swim(int lSwim) {
         System.out.println("Птица не умеет плавать!");
    }

    @Override
    public void jump(double hJump) {
        if (hJump < hJumpMax) {
            System.out.println("Птица перепрыгнула!");
        }
        else System.out.println("Слишком далеко!");
    }

    public Bird() {
        count = count+1;
        System.out.println("Всего птиц: " + count);
        super.count();
    }
}
