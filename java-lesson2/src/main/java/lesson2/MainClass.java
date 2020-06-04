package lesson2;

import java.util.Arrays;

public class MainClass {

    //1 задание
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (1 == arr1[i]) {
                arr1[i] = 0;
            } else arr1[i] = 1;
        }
        System.out.println(Arrays.toString(arr1));


        //2 задание

        int[] arr2 = new int[8];
        int j = 0;
        for (int k = 0; k < arr2.length; k++) {
            arr2[k] = j;
            j = j + 3;
        }
        System.out.println(Arrays.toString(arr2));

        //3 задание
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int l = 0; l < arr3.length; l++) {
            if (arr3[l] < 6) {
                arr3[l] = 2 * arr3[l];
            }
        }
        System.out.println(Arrays.toString(arr3));

        //4 задание
        int[][] arr4 = new int[4][4];
        for (int n = 0; n < arr4.length; n++) {
            for (int m = 0; m < arr4.length; m++) {
                if (n == m) {
                    arr4[n][m] = 1;
                }
 if ((n+m) == (arr4.length-1)) {
                    arr4[n][m] = 1;
                }
System.out.print(arr4[n][m]);
            }
            System.out.println();
        }
//5 задание
        int[] arr5 = {5, 7, 3, 11, 4};
        int min = arr5[0];
        int max = arr5[0];
        for (int h=0; h < arr5.length; h++) {
            if (arr5[h]<=min) {
                min=arr5[h];
            }
            if (arr5[h]>=max) {
                max=arr5[h];
            }
        }
        System.out.println(min + " " + max);

    }
}
