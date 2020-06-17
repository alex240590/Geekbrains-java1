package lesson6;

//класс Животные с методом для подсчета всех созданных Животных и методами
// бегать, плавать, прыгать, которые переопределяются в подвидах

public class Animal {
    public static int count = 0;
    public void count() {
        count = count + 1;
        System.out.println("Всего животных: " + count);
    }

    public void run(int lRun) {
System.out.println("Животное пробежало " + lRun + " метров");
    }
    public void swim(int lSwim) {
        System.out.println("Животное проплыло " + lSwim + " метров");
    }

    public void jump(double hJump) {
        System.out.println("Животное прыгнуло на " + hJump + " метров");
    }
}
