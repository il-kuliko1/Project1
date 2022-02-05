package ru.geekbrains.core_1.lessons.lesson_1;

public class HomeWorkApp {
    public static void main(String[] args){
       // printThreeWords();
        //checkSumsign(-5,5);
        //printColor();
        compareNumbers();



            }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumsign(int a, int b) {
        int c=a+b;
        if (c>0){
            System.out.println("Сумма "+a+" и "+b+" положительная, и равна = "+ c);
            }
        else if(c<0){
            System.out.println("Сумма "+a+" и "+b+" отрицательная, и равна =  "+c);
        }else System.out.println("0");
    }

    public static void printColor(){
        int value=1010;

        if (value<=0) System.out.println("Красный");
        else if (0 < value && value<= 100) System.out.println("Желтый");
        else if (value>100) System.out.println("Зелёный");
    }

    public static void compareNumbers(){
        int a=10;
        int b=11;
        if (a>=b) System.out.println("a>=b");
        else System.out.println("a<b");


    }
}


