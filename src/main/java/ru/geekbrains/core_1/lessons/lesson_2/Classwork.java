package ru.geekbrains.core_1.lessons.lesson_2;

public class Classwork {
    public static void main(String[] args) {
//      checkSum(5, 5);
//      printTrue(isYearLong(1704));
//      checkPos(56);
//        printGovnoNRaz("Govennoe govno",15);
//        isYearLong(2000);
        /*for (int i = 0; i < 2022; i++) {
            isYearLong(i);

        }*/

        /*for (int i = 0; i < 6; i++) { //звёзды и нули
            for (int j = 0; j < 6; j++) {
                if (j < 3) {System.out.print("* ");}
                else       {System.out.print("0 ");}
                }
            System.out.println();
            }*/

       /* for (int i = 0; i < 6; i++) { //квадрат
            for (int j = 0; j < 6; j++) {
                if (j == 0||j==5||i==0||i==5) {System.out.print("0 ");}
                else       {System.out.print("* ");}
            }
            System.out.println();
        }*/

        /* for (int i = 0; i < 6; i++) {//шахматы

             for (int j = 0; j < 6; j++) {
                if ((i+j)%2==0) {System.out.print("* ");}
                else   {System.out.print("0 ");}
            }
            System.out.println();
        }*/

         /*for (int i = 0; i < 6; i++) { //пустой квадрат
            for (int j = 0; j < 6; j++) {
                if (j == 0||j==5||i==0||i==5) {System.out.print("0 ");}
                else       {System.out.print("  ");}
            }
            System.out.println();
        }*/

        /*for (int i = 0; i < 6; i++) { //зачеркнутый квадрат
            for (int j = 0; j < 6; j++) {
                if (j == 0||j==5||i==0||i==5) {System.out.print("0 ");}
                else  if(i==j)     {System.out.print("0 ");}
                else       {System.out.print("  ");}
            }
            System.out.println();
        }*/

       /* for (int i = 0; i < 6; i++) { //треугольник
            for (int j = 0; j < 6; j++) {
                if (j == 0||i==5) {System.out.print("0 ");}
                else  if(i==j)     {System.out.print("0 ");}
                else       {System.out.print("  ");}
            }
            System.out.println();
        }*/

       /* for (int i = 0; i < 6; i++) { //с дыркой квадрат
            for (int j = 0; j < 6; j++) {
                if (j == 0||j==5||i==0||i==5||j==1||i==1||j==4||i==4) {System.out.print("0 ");}
               else       {System.out.print("  ");}
            }
            System.out.println();
        }*/

         /*for (int i = 0; i < 6; i++) { //Пиздец, товарищи!
            for (int j = 0; j < 6; j++) {
                if (j<4&&i>=0&&i<=1) {System.out.print("* ");}
                else if (i==2||i==3){System.out.print("* ");}
                else if (j>1&&i>=4&&i<=5){System.out.print("* ");}

               else       {System.out.print("  ");}
            }
            System.out.println(i);
        }*/


        }





    //1
    public static boolean checkSum(int a, int b) {
        if (10 <= (a + b) && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printTrue(boolean a) {
        System.out.println(a);

    }
//2
public static void checkPos(int a) {
    if (a >= 0) {
        System.out.println(a + " is positive");
    } else {
        System.out.println(a + " is negative");
    }
}

    //3
    public static boolean checkPos2(int a) {
        if (a >= 0) {
            return true;
        } else {
            return false;
        }

    }
//4
public static void printGovnoNRaz(String a, int b){
    for (int i=0; i < b; i++) {
        System.out.println(a+" "+i);
    }

    }
public static boolean isYearLong(int a){
    if (a%400==0){
        System.out.println("Год " + a + " весокосный");
        return true;
    } else if (a % 100 == 0) {
        System.out.println("Год " + a + " ---");
        return false;
    } else if (a % 4 == 0) {
        System.out.println("Год " + a + " весокосный");
        return true;
    } else {
        System.out.println("Год " + a + " ___");
        return false;
        }





}

}













