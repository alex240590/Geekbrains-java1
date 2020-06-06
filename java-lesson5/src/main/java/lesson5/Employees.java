package lesson5;

// Класс сотрудников

public class Employees {

    // Поля экземпляров класса "сотрудники"

    String FullName;
    String Position;
    String Email;
    long PhoneNumber;
    int Salary;
    int Age;

    // Конструктор класса сотрудников с передачей полного набора инфомации для полей

    Employees(String FullName, String Position, String Email, long PhoneNumber, int Salary, int Age) {
        this.FullName = FullName;
        this.Position = Position;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Salary = Salary;
        this.Age = Age;
    }

    // Конструктор по умолчанию

    Employees() {
        this.FullName = "Full name";
        this.Position = "Position";
        this.Email = "Email";
        this.PhoneNumber = 1234567890;
        this.Salary = 1234567;
        this.Age = 123;
    }

    // Метод, выводящий в консоль информацию о сотруднике

    public void showInfo() {
        System.out.println("Full name: " + this.FullName);
        System.out.println("Position: " + this.Position);
        System.out.println("E-mail: " + this.Email);
        System.out.println("Phone number: " + this.PhoneNumber);
        System.out.println("Salary: " + this.Salary);
        System.out.println("Age: " + this.Age);
        System.out.println();
    }

    // В главном методе создаются экземпляры класса сотрудников

    public static void main (String[] args) {
        Employees employee1 = new Employees("Ben", "Junior", "bs@mail.ru", 1234567, 12345, 30);
        Employees employee2 = new Employees("Alex", "Junior", "as@mail.ru", 1234567, 12345, 25);
        Employees employee3 = new Employees("Denis", "CEO", "dn@mail.ru", 1234567, 12345, 45);
        Employees employee4 = new Employees("Max", "Junior", "ms@mail.ru", 1234567, 12345, 55);
        Employees employee5 = new Employees("Dan", "Junior", "ds@mail.ru", 1234567, 12345, 30);


        // Экзэмпляры класса сотрудников заносятся в массив,
        // затем из него с помощью цикла выводятся в терминал элементы массива с условияем возраста больше 40

        Employees[] EmloyeesList = {employee1, employee2, employee3, employee4, employee5};
        for (int i = 0; i < 5; i++) {
            if (EmloyeesList[i].Age > 40) {
                EmloyeesList[i].showInfo();
            }
        }


    }
}
