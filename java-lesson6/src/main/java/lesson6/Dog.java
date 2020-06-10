package lesson6;


// класс Собака

public class Dog extends Animal {
//    public static int lRunMax = 500;

    //ограничения на действия собак

    public static int lSwimMax = 10;
    public static double hJumpMax = 0.4;
    public static int count = 0;

    //lRunMax устанавливает ограничение на бег собаки от 400 до 600

    public int lRunMax = 400 + (int)(Math.random()*200);

    // переопределенные методы из класса Животные

    @Override
    public void run(int lRun) {
        if (lRun < lRunMax) {
            System.out.println("Пес пробежал " + lRun + " метров!" + "(ограничение: " + lRunMax + ")");
        }
        else System.out.println("Слишком далеко бежать!");
    }

    @Override
    public void swim(int lSwim) {
        if (lSwim < lSwimMax) {
            System.out.println("Пес проплыл!");
        }
        else System.out.println("Слишком далеко плыть!");
    }

    @Override
    public void jump(double hJump) {
        if (hJump < hJumpMax) {
            System.out.println("Пес перепрыгнул!");
        }
        else System.out.println("Слишком далеко!");
    }

    // метод подсчета созданных собак и вызов родительского метода подсчета животных

    public Dog() {
        count = count+1;
        System.out.println("Всего собак: " + count);
        super.count();
    }

}
