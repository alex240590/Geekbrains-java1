package lesson6;

public class Horse extends Animal {
    public static int lRunMax = 1500;
    public static int lSwimMax = 100;
    public static double hJumpMax = 3;
    public static int count = 0;

    @Override
    public void run(int lRun) {
        if (lRun < lRunMax) {
            System.out.println("Лошадь пробежала!");
        }
        else System.out.println("Слишком далеко бежать!");
    }

    @Override
    public void swim(int lSwim) {
        if (lSwim < lSwimMax) {
            System.out.println("Лошадь проплыла!");
        }
        else System.out.println("Слишком далеко плыть!");
    }

    @Override
    public void jump(double hJump) {
        if (hJump < hJumpMax) {
            System.out.println("Лошадь перепрыгнула!");
        }
        else System.out.println("Слишком далеко!");
    }

    public Horse() {
        count = count+1;
        System.out.println("Всего лошадей: " + count);
        super.count();
    }
}
