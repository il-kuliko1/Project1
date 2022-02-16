package ru.geekbrains.core_1.lessons.lesson_3;

import java.util.Arrays;

public class Classwork {
    public static void main(String[] args) {
//        zad1();
//        zad2();
//        zad3();
        zad4();


    }

    private static void zad4() {
        int[][] Hui4 = new int[5][5];
        for (int i = 0; i < Hui4.length; i++) {
            for (int j = 0; j < Hui4[i].length; j++) {
                if (i == j) {
                    Hui4[i][j] = 1;
                }else if (i+j==4){Hui4[i][j] = 1;}

                else {
                    Hui4[i][j] = 0;
                }
                System.out.print(Hui4[i][j] + " ");
            }
            System.out.println();

        }
    }

    private static void zad3() {
        int[] Hui3 = {1, 3, 6, 8, 7, 9, 5, 3, 5, 7, 9, 6, 3, 11, 14, 16, 176, 86, 23};
        System.out.println(Arrays.toString(Hui3));
        for (int i = 0; i < Hui3.length; i++) {
            if (Hui3[i] < 6) {
                Hui3[i] *= 2;
            }

        }
        System.out.println(Arrays.toString(Hui3));
    }

    private static void zad2() {
        int[] Hui1 = new int[101];
        for (int i=0;i<Hui1.length;i++){
            Hui1[i]=i;
            System.out.print(Hui1[i]+" ");
        }
    }

    private static void zad1() {
        int[] Hui = {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0};
        System.out.println(Arrays.toString(Hui));
        for (int i = 0; i < Hui.length; i++) {
            if (Hui[i] == 1) {
                Hui[i] = 0;
            } else {
                Hui[i] = 1;
            }

        }
        System.out.println(Arrays.toString(Hui));
    }


}

