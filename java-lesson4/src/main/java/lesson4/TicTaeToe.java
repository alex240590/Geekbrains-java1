package lesson4;


import java.util.Random;
import java.util.Scanner;

public class TicTaeToe {

    // Заведение констант на допустимый ввод
    // Какими символами (фигками) играет игрок
    private static final char DOT_HUMAN = 'X';
    // Что вводит компьютер
    private static final char DOT_AI = 'O';
    // Символ пустой клетка
    private static final char DOT_EMPTY = ' ';

    // Упрощения вместо использования field.length
    private static int fieldSizeX;
    private static int fieldSizeY;
    // Игровое поля
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    //main
    public static void main(String[] args) {
        int fieldSize = 5;
        while (true) {
            init(fieldSize);
            printField();
            playOnce(fieldSize);
            System.out.println("Играть сначала?");
            if (SCANNER.next().equals("no")) {
                break;
            }
        }
    }

    private static void playOnce(int fieldSize) {
        while (true) {
            humanTurn();
            printField();
            if (isWinnerExists(DOT_HUMAN)) {
                System.out.println("Победил Игрок!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printField();
            if (isWinnerExists(DOT_AI)) {
                System.out.println("Победил Компьютер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }

    //initField
    private static void init(int fieldSize) {
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;

        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    //printField
    private static void printField() {
        System.out.println("=============");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("| ");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();
        }
    }

    //isValidField
    // Проврека, что координаты находятся в допустимом диапазоне
    private static boolean isValidField(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //isNotEmptyField
    // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
    private static boolean isNotEmptyField(int x, int y) {
        return field[y][x] != DOT_EMPTY;
    }

    //humanTurn
    // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
    private static void humanTurn() {
        // 3 1
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до " + fieldSizeY + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidField(x, y) || isNotEmptyField(x, y));
        field[y][x] = DOT_HUMAN;
    }

    //aiTurn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (isNotEmptyField(x, y));
        field[y][x] = DOT_AI;
    }

    //isDraw
    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //checkWin
    private static boolean isWinnerExists(char symb) {
      //  if (field[0][0] == symb && field[0][1] == symb && field[0][2] == symb) return true;
      //  if (field[1][0] == symb && field[1][1] == symb && field[1][2] == symb) return true;
      //  if (field[2][0] == symb && field[2][1] == symb && field[2][2] == symb) return true;

      //  if (field[0][0] == symb && field[1][0] == symb && field[2][0] == symb) return true;
      //  if (field[0][1] == symb && field[1][1] == symb && field[2][1] == symb) return true;
     //   if (field[0][2] == symb && field[1][2] == symb && field[2][2] == symb) return true;

      //  if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
     //   if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) return true;



        // Задание 2. Реализация проверки победы с использованием циклов для поля 3х3



       // for (int i=0; i<fieldSizeX; i++) {

            // if (field[i][0] == symb && field[i][1] == symb && field[i][2] == symb) return true;

     // }


      //  for (int i=0; i<fieldSizeY; i++) {

         //   if (field[0][i] == symb && field[1][i] == symb && field[2][i] == symb) return true;

      //  }
      //  if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb) return true;
      //  if (field[2][0] == symb && field[1][1] == symb && field[0][2] == symb) return true;
     //   return false;

        // Задание 3. Логика проверки победы для поля 5х5 и количества фишек 4.

        for (int i=0; i<fieldSizeX; i++) {

            if (field[i][0] == symb && field[i][1] == symb && field[i][2] == symb && field[i][3] == symb) return true;
            else if (field[i][1] == symb && field[i][2] == symb && field[i][3] == symb && field[i][4] == symb) return true;
        }


        for (int j=0; j<fieldSizeX; j++) {

            if (field[0][j] == symb && field[1][j] == symb && field[2][j] == symb && field[3][j] == symb) return true;
            else if (field[1][j] == symb && field[2][j] == symb && field[3][j] == symb && field[4][j] == symb) return true;
        }



        if (field[1][0] == symb && field[2][1] == symb && field[3][2] == symb && field[4][3] == symb) return true;
        if (field[0][1] == symb && field[1][2] == symb && field[2][3] == symb && field[3][4] == symb) return true;
        if (field[0][0] == symb && field[1][1] == symb && field[2][2] == symb && field[3][3] == symb) return true;
        if (field[1][1] == symb && field[2][2] == symb && field[3][3] == symb && field[4][4] == symb) return true;
        if (field[0][3] == symb && field[1][2] == symb && field[2][1] == symb && field[3][0] == symb) return true;
        if (field[1][4] == symb && field[2][3] == symb && field[3][2] == symb && field[4][1] == symb) return true;
        if (field[4][0] == symb && field[3][1] == symb && field[2][2] == symb && field[1][3] == symb) return true;
        if (field[3][1] == symb && field[2][2] == symb && field[1][3] == symb && field[0][4] == symb) return true;
        return false;
    }


}