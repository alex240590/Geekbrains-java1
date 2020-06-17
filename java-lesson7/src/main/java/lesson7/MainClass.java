package lesson7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        //Создаю 2 строки для записи их в 2 файла

        String s1 = "Hello, world. This is the first line in the first file";
        String s2 = "Hello, world. This is the second line in the second file";
        String word = "Hello";

        //Записываю 2 строки в 2 файла

        try {
            PrintStream ps1 = new PrintStream(new FileOutputStream("file1.txt"));
            ps1.println(s1);
            ps1.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            PrintStream ps2 = new PrintStream(new FileOutputStream("file2.txt"));
            ps2.println(s2);
            ps2.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }


        //"Склеиваю" два файла в один. Считываю первый файл, записываю в третий,
        //считываю второй файл, записываю в третий

        ArrayList<String> strings1 = new ArrayList<String>();

        try {
            Scanner scanner1 = new Scanner(new FileInputStream("file1.txt"));
            Scanner scanner2 = new Scanner(new FileInputStream("file2.txt"));
            PrintStream ps3 = new PrintStream(new FileOutputStream("file3.txt"));


            while (scanner1.hasNextLine()) {
                String line1 = scanner1.nextLine().trim();
                strings1.add(line1);
                ps3.print(line1);
                System.out.println(line1);
            }
            while (scanner2.hasNextLine()) {
                String line2 = scanner2.nextLine().trim();
                strings1.add(line2);
                ps3.print(line2);
                System.out.println(line2);
            }

            scanner1.close();
            scanner2.close();
            ps3.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }

        //Попытка сделать 3 задание через сравнение массивов символов из файла и слова
        //Данная реализация не работает

        //Считываю файл в ArrayList<Character>

//        int c;
//        ArrayList<Character> char1 = new ArrayList<Character>();
//        try {
//            FileInputStream is = new FileInputStream("file1.txt");
//            while ((c = is.read()) != -1)
//                System.out.print((char) c);
//            char1.add((char) c);
//            is.close();
//        } catch (IOException e4) {
//            e4.printStackTrace();
//        }
//
        //Преобразую слово в массив символов

//        char[] word1 = word.toCharArray();
//        for (int i = 0; i < word1.length; i++) {
//            System.out.print(word1[i]);
//        }
//
        //Преобразую символы из ArrayList<Character> в массив

//        int char2Length = char1.size();
//        char[] char2 = new char[char2Length];
//        for (int i=0; i<char2.length; i++) {
//            char2[i] = char1.get(i);
//        }
//
        //Сравниваю элементы массивов символов из файла и слова

//        for (int i = 0; i < char2.length; i++) {
//            System.out.print("level1");
//            if (char2[i] == word1[0]) {
//                System.out.print("level2");
//                for (int j = i; j < i+word1.length; j++) {
//                    System.out.print("level3");
//                    if (char2[j] == word1[(j-i)]) {
//                        System.out.println("word is in file");
//                    }
//                }
//            }
//
//        }
    }
}
